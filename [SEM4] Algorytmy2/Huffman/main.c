#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#define SZER_EKR 80  /* szerokosc ekranu */
#define IL_POZ   6


int fre[257];
int noChar;
char codeTab[256][32];

typedef struct node{
    int value;
    char letter;
    struct node *left,*right;
} Node;


void countFre(char *nazwa){
  int len,i;
  FILE* plik;
  char buff[1024];

  if((plik=fopen(nazwa,"r"))==NULL) {
    printf("Nie moge otworzyc pliku\n");
    exit(1);
  }

  while(fgets(buff,1024,plik)!=NULL){
    len=strlen(buff);
    for(i=0;i<len;i++){
      fre[buff[i]]++;
    }
  }
  fclose(plik);
}
void countChar(){
  int i;
  for(i=0;i<257;i++)
    if(fre[i]>0) noChar++;
}
void fillQue(int tab[][2]){
  int i;
  int j=0;
  for(i=0;i<257;i++){
    if(fre[i]>0){
      tab[j][0]=i;
      tab[j][1]=fre[i];
      j++;
    }
  }
}
void sort (int tab[][2], int size){
    int i,j; // i = rows
    int a,b;

    for (i=0; i < size; i++)
    {
        for (j=0; j < size-1; j++)
        {
            if (tab[i][1] > tab[j][1]) //names  = col 1 , rank = col 0
            {
                a = tab[i][1];
                b = tab[i][0];
                tab[i][1] = tab[j][1];
                tab[i][0] = tab[j][0];
                tab[j][1] = a;
                tab[j][0] = b;
            }
        }
    }
}

int findSmaller (Node *array[], int differentFrom){
    // differentFrom, szukaj min, ale innego niz differentFrom
    int smaller;
    int i = 0;


    while (array[i]->value==-1)
        i++;
    smaller=i;
    if (i==differentFrom){
        i++;
        while (array[i]->value==-1)
            i++;
        smaller=i;
    }

    for (i=1;i<noChar;i++){
        if (array[i]->value==-1)
            continue;
        if (i==differentFrom)
            continue;
        if (array[i]->value<array[smaller]->value)
            smaller = i;
    }

    return smaller;
}
void buildHuffmanTree(Node **tree, int tab[][2]){
    Node *temp;
    Node *array[noChar]; // to co na poczatku
    int i, subTrees = noChar;
    int smallOne,smallTwo;



    //wypelnianie drzewek
    for (i=0;i<noChar;i++){
        array[i] = malloc(sizeof(Node));
        array[i]->value = tab[i][1];
        array[i]->letter = tab[i][0];
        array[i]->left = NULL;
        array[i]->right = NULL;
    }

    for (i=0;i<noChar;i++){
        printf("%c: %d\n",array[i]->letter,array[i]->value);
    }


    while (subTrees>1){
        smallOne=findSmaller(array,-1);
        smallTwo=findSmaller(array,smallOne);
        temp = array[smallOne]; //zachowanie wiekszego elementu elementu
        array[smallOne] = malloc(sizeof(Node)); // nowy wezel z suma
        array[smallOne]->value = temp->value + array[smallTwo]->value; // wartosc suma dwoch poprzednich
        array[smallOne]->letter=0; // ustalenie, ze 255 to suma, a nie litera
        array[smallOne]->left=temp;
        array[smallOne]->right=array[smallTwo];
        array[smallTwo] = malloc(sizeof(Node));
        array[smallTwo]->value=-1; //mniej o jeden wezel, -1 oznacza ze nic tam nie ma
        subTrees--;
    }

    *tree = array[smallOne];
    return;}

//DRUKOWANIE
void drukuj(Node *w);
char wydruk[IL_POZ+1][SZER_EKR];
void drukujost(Node *w, int l, int p,int poziom){
       int srodek = (l+p)/2;
       if (w==NULL)   return;
       wydruk[poziom][srodek]='*';
}
void drukujwew(Node *w, int l, int p,int poziom){
       int srodek = (l+p)/2;
       int i,dl;
       char s[19];
       if (w==NULL)    return;
        if (w->letter==0) dl=sprintf(s,"%d",w->value);
        else if(w->letter=='\n') dl=sprintf(s,"\\n:%d",w->value);
        else dl=sprintf(s,"%c:%d",w->letter,w->value);
       for (i=0;i<dl;i++)
         wydruk[poziom][srodek-dl/2+i]=s[i];
       if (++poziom<IL_POZ){
         drukujwew(w->left,l,srodek,poziom) ;
         drukujwew(w->right,srodek+1,p,poziom) ;
       }
       else {
         drukujost(w->left,l,srodek,poziom) ;
         drukujost(w->right,srodek+1,p,poziom) ;
       }
}
void drukuj(Node *w){
  int j,i;
  for (i=0;i<=IL_POZ;i++)
    for (j=0;j<SZER_EKR;j++)
      wydruk[i][j] = ' ';
  drukujwew(w,0,SZER_EKR,0);
  for (i=0;i<=IL_POZ;i++){
      for (j=0;j<SZER_EKR;j++)
        putchar(wydruk[i][j]);
      printf("\n");
  }
}


//GENEROWANIE KODOW HUFFMANA
int isLeaf(Node *root){ return !(root->left) && !(root->right) ;}
void genCodes(Node *root, int arr[],int top){
  if (root->left)
  {
      arr[top] = 0;
      genCodes(root->left, arr, top + 1);
  }

  // Assign 1 to right edge and recur
  if (root->right)
  {
      arr[top] = 1;
      genCodes(root->right, arr, top + 1);
  }

  // If this is a leaf node, then it contains one of the input
  // characters, print the character and its code from arr[]
  if (isLeaf(root))
  {
      int i;
      for (i = 0; i < top; ++i){
        codeTab[root->letter][i]=arr[i]+48;
      }
  }
}
void compress(char *odczyt,char *zapis){
      int len,i,liczOrg=0,liczKom=0;
      FILE* input;
      FILE* output;
      char buff[1024];
      char x[32];

      if((input=fopen(odczyt,"r"))==NULL) {
        printf("Nie moge otworzyc pliku\n");
        exit(1);
      }

      if((output=fopen(zapis,"w"))==NULL) {
        printf("Nie moge otworzyc pliku\n");
        exit(1);
      }


      while(fgets(buff,1024,input)!=NULL){
        len=strlen(buff);
        liczOrg+=len;
        for(i=0;i<len;i++){
          strcpy(x, codeTab[buff[i]]);
          liczKom+=strlen(x);
          fputs(x,output);
          // fputs("|",output);
        }
      }

      printf("\nILOSC BITOW PRZED KOMPRESJA: %db\n",liczOrg*8);
      printf("ILOSC BITOW PO KOMPRESJI: %db\n", liczKom);



      fclose(input);
      fclose(output);
}


int main(int argc, char *argv[]){
  Node *tree;
  int i,j;

  if(argc>1){
    countFre(argv[1]);
    countChar(); // zliczanie ilosci niepowtarzajacych sie liter
    //tablica na literki i jej wypelnienie
    int Q[noChar][2];fillQue(Q);sort(Q,noChar);

    buildHuffmanTree(&tree, Q);
    printf("\nDRZEWO:\n");
    drukuj(tree);

    int arr[100],top=0;
    genCodes(tree,arr,top);

    //KODY DLA POWTARZAJACYCH SIE LITER
    for(i=0;i<256;i++)
      if(strlen(codeTab[i])>0) printf("%c:%s\n", i,codeTab[i]);

    compress(argv[1], "huff.txt");
  }else printf("ZA MALO ARGUMENTWO!\n");

  return 0;
}
