//                                          pmp@inf.ug.edu.pl  2014
// drukowanie drzew cz-cz z wartownikiem wspolnym
// dla wszystkich wezlow:
// drukowanie na ekran tekstowy i przez dot z pakietu graphviz

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define RED 1        /* stala oznaczajaca kolor wezla */
#define BLACK 0      /* stala oznaczajaca kolor wezla */
#define SZER_EKR 80  /* szerokosc ekranu */
#define IL_POZ   5   /* ilosc poziomow drzewa, ktore beda wydrukowane   */
                     /* gwiazdka bedzie sygnalizowac istnienie nizszych */
                     /* poziomow                                        */

/* struktury danych do reprezentowania drzewa */
/* wskaznik na wezel drzewa  */
struct Wskwezla{
	int klucz;
	struct Wskwezla *left, *right, *p;
	int kolor;
};

/* drzewa z wartownikami: wezel wskazywany przez "nil" jest wartownikiem
   zastepujacym NULL; dla korzenia pole "p" ma wartosc "nil";
   przy usuwaniu trzeba odpowiednio wypelnic pole nil->p
*/
struct Wskwezla *nil;
struct Wskwezla *root;

void nilInit(void){
/* funkcja inicjujaca nil; musi byc wywolana przed budowaniem drzewa */
  nil= (struct Wskwezla *) malloc(sizeof(struct Wskwezla));
  nil->p = NULL;
  nil->kolor = BLACK;
  nil->left = nil->right = NULL;
}

struct Wskwezla *nowyWezel(int klucz, int kolor)
{
     // tworzy nowy wezel. Przydatne do testowania wydruku
     struct Wskwezla *w = (struct Wskwezla *) malloc(sizeof(struct Wskwezla));
     w->p = nil;
     w->klucz=klucz;
     w->kolor = kolor;
     w->left = w->right = nil;
     return w;
}



void drukuj(struct Wskwezla *w);
/* funkcja drukujaca drzewo binarne na ekranie (tutaj tylko deklaracja) */
/* funkcja drukuje drzewo o korzeniu "w"                                */

void drukujDot(struct Wskwezla *r);
  // generuje w plikach drzewo0.gv,  drzewo1.gv ...
  // opis drzew o korzeniu r do wydrukowania przez program dot
  // zlecenie "dot -Tpdf -O drzewo1.gv" utworzy plik "drzewo1.gv.pdf"

/* ------------  implementacja ------------------------------------- */
char wydruk[IL_POZ+1][SZER_EKR];

void drukujost(struct Wskwezla *w, int l, int p,int poziom){
       int srodek = (l+p)/2;
       if (w==nil)
        return;
       wydruk[poziom][srodek]='*';
}

void drukujwew(struct Wskwezla *w, int l, int p,int poziom){
       int srodek = (l+p)/2;
       int i,dl;
       char s[19];
       if (w==nil)    return;
       if (w->kolor==BLACK)
         dl=sprintf(s,"%d",w->klucz);
       else
	 //	        dl=sprintf(s,"\e[31m%+d\e[0m",w->klucz);
       dl=sprintf(s,"%+d",w->klucz);
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

void drukuj(struct Wskwezla *w){
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

void drukujKrawedz(FILE *plikwy, struct Wskwezla *r, int z, struct Wskwezla *syn, int zs){
// wezel r o numerze z jest juz wydrukowany
// teraz drukujemy jego syna "syn" o numerze zs oraz krawedz miedzy nimi
  if (syn == nil){
    fprintf(plikwy,"%d [shape=circle, style=invisible, label=\"",zs);
    fprintf(plikwy,"%d ",0);
    fprintf(plikwy,"\"]\n");
    fprintf(plikwy,"%d -- %d [style=invis];\n ",z,zs);
  } else{
    if (syn->kolor == RED)
      fprintf(plikwy,"%d [shape=circle, color=red, label=\"",zs);
    else
      fprintf(plikwy,"%d [shape=circle, color=black, label=\"",zs);
    fprintf(plikwy,"%d ",syn->klucz);
    fprintf(plikwy,"\"]\n");
    fprintf(plikwy,"%d -- %d ;\n",z,zs);
  }
}

int rekDrukujDot(struct Wskwezla *r, int z, FILE *plikwy){
  // drukuje drzewo o korzeniu r
  // z  - numer wezla r
  // zwraca najwiekszy numer wezla w poddrzewie, ktorego jest korzeniem
  // zakladamy, ze korzen r jest juz wydrukowany
  int nz,i;
  if (r == nil) return z;
  else{
    drukujKrawedz(plikwy,r,z,r->left,z+1);
    nz=rekDrukujDot(r->left,z+1,plikwy);
    drukujKrawedz(plikwy,r,z,r->right,nz+1);
    nz=rekDrukujDot(r->right,nz+1,plikwy);
    return nz;
  }
}

void drukujDot(struct Wskwezla *r){
  // generuje w plikach drzewo0.gv, dzrewo1.gv, ...
  // opisy drzew o korzeniu r pzeznaczone do wydrukowania przez program dot
  // zlecenie "dot -Tpdf -O drzewo1.gv" utworzy plik "drzewo1.gv.pdf"
  static int gdzie=0;
  char numer[10];
  char nazwap[20]="drzewo";
  FILE *plikwy;
  snprintf(numer,9,"%d",gdzie);
  strcat(nazwap,numer);
  strcat(nazwap,".gv");
  plikwy=fopen(nazwap,"w");
  gdzie++;
  fprintf(plikwy, "graph drzewo{\n");
  fprintf(plikwy, "size = \"2,20\"");
  if (r!=nil){
    if (r->kolor == RED)
      fprintf(plikwy,"%d [shape=circle, color=red, label=\"",0);
    else
      fprintf(plikwy,"%d [shape=circle, color=black, label=\"",0);
    fprintf(plikwy,"%d ",r->klucz);
    fprintf(plikwy,"\"]\n");
    rekDrukujDot(r,0,plikwy);
  }
  fprintf(plikwy, "}\n");
  fclose(plikwy);
  printf("wydrukowane %s\n",nazwap);
}

/* ------------- miejsce na inne funkcje -------------------- */

void rightRotate(struct Wskwezla *root, struct Wskwezla *y)
{
    struct Wskwezla *x;
    x = y->left;
    y->left = x->right;
    if ( x->right != NULL)
    {
        x->right->p = y;
    }
    x->p = y->p;
    if( y->p == NULL)
    {
        root = x;
    }
    else if( y->klucz == y->p->left->klucz)
    {
        y->p->left = x;
    }
    else
        y->p->right = x;
    x->right = y;
    y->p = x;

return;
}

void leftRotate(struct Wskwezla *root, struct Wskwezla *x){
struct Wskwezla *y;
y = x->right;  //y wskazuje na prawego syna x
x->right = y->left; // lewy syn y staje sie prawym synem x
if( y->left != NULL)
{
    y->left->p = x;
}
y->p = x->p;
if( x->p == NULL)
{
    root = y;
}
else if( x->klucz == x->p->left->klucz)
{
    x->p->left = y;
}
else x->p->right = y;
y->left = x;
x->p = y;

return;
}

void rbInsert(int val)
{
    struct Wskwezla *z = (struct Wskwezla *) malloc(sizeof(struct Wskwezla));
    z->klucz = val;
    z->left = NULL;
    z->right = NULL;
    z->kolor = RED;
    struct Wskwezla *x = root; //x wskazuje na aktualne drzewo
    struct Wskwezla *y; //pomocniczy
    if ( root == NULL ) //jesli drzewo puste
    {
        root = z; //z staje sie korzeniem, kolorowanie na czarno i STOP
        root->kolor = BLACK;
        return;
    }
    while ( x != NULL) //petla dopoki nie dojdziemy do straznika (NULL), odpowiada za
                       //wstawienie nowego klucza 'na sucho'
    {
        y = x;   //przypisanie aktualnego x do y (x zmienia sie w petli, bo idziemy caly czas w dol drzewa,
                //wiec y zachowuje aktualny stan x)
        if ( z->klucz < x->klucz) //sprawdzenie czy z ma isc w lewo czy w prawo
        {
            x = x->left; //w lewo
        }
        else
            x = x->right; //w prawo
    }
    z->p = y; //po tym jak znaleziono miejsce dla nowego klucza z, ojcem z staje sie y
    if ( y == NULL)
    {
        root = z;
    }
    else if( z->klucz < y->klucz )//koncowe sprawdzenie czy wstawic z po lewej czy po prawej stronie y
    {
        y->left = z;
    }
    else
        y->right = z;
    rbInsertFix(root,z); //naprawa drzewa

    return;
}

void rbInsertFix(struct Wskwezla *root, struct Wskwezla *z) //odpowiada za naprawe drzewa
{
struct Wskwezla *y;
while (z->p->kolor == RED)
    {
    if (z->p->klucz == z->p->p->left->klucz)
    {
        y = z->p->p->right;
        if (y->kolor == RED)
        {
            z->p->kolor = BLACK;
            y->kolor = BLACK;
            z->p->p->kolor = RED;
            z = z->p->p;
        }
        else if (z->klucz == z->p->right->klucz)
        {
            z = z->p;
            leftRotate(root,z);
        }
        z->p->kolor = BLACK;
        z->p->p->kolor = RED;
        rightRotate(root,z->p->p);
    }
    else
    {
        y = z->p->p->left;
        if (y->kolor == RED)
        {
            z->p->kolor = BLACK;
            y->kolor = BLACK;
            z->p->p->kolor = RED;
            z = z->p->p;
        }
        else if (z->klucz == z->p->left->klucz)
        {
            z = z->p;
            rightRotate(root,z);
        }
        z->p->kolor = BLACK;
        z->p->p->kolor = RED;
        leftRotate(root,z->p->p);
    }
}
root->kolor = BLACK;
}


/*
 void InnyInstert(int wartosc)
{

    struct Wskwezla *w = (struct Wskwezla *) malloc(sizeof(struct Wskwezla));
    w->left = nil;
    w->right = nil;
    w->p = root;
    w->klucz = wartosc;
    if(w->p = nil) //K07
    {
        root = w;
    }
    else
    {
        while(true)
        {
            if(wartosc < (w->p->klucz)) //K10
            {
                if((w->p->left) == nil) //K14
                {
                    w->p->left = w;
                    break;
                }
                else
                {
                    w->p = w->p->left; //K15
                }
            }
            else
            {
                if(w->p->right == nil) //K11
                {
                    w->p->right = w;
                    break;
                }
                else
                {
                    w->p = w->p->right; //K12
                }
            }
        }
    }
    w->kolor = RED; //K17
    while(w!=root && w->p->kolor = RED) //K18
    {
        if(w->p != w->p->p->left)
        {

        }
    }
    root->kolor = BLACK //K48
}
*/

void DRUKUJ(struct Wskwezla *root)
{
    if (root != NULL)
    {
        DRUKUJ(root->left);
        printf("%d(%d) ; ", root->klucz, root->kolor);
        DRUKUJ(root->right);
    }
}
/* ----------------- program testujacy -----------------------*/


int main(void){

    //nilInit();
    int petla=1;
    while(petla=1){
        printf("MENU: \n 1.Dodaj element \n 2.Wyswietl drzewo \n 3.Zamknij program \n");
        int wybor, wartosc;
        scanf("%d", &wybor);
        switch(wybor){
        case 1:
            printf("Podaj wartosc calkowita, ktora chcesz dodac: \n");
            scanf("%d", &wartosc);
            rbInsert(wartosc);
            break;
        case 2:
            //DRUKUJ(root);
						drukuj(root);
            break;
        case 3:
            return 0;
            break;
        default:
            printf("Blad, wybierz jeszcze raz. \n");

        }
    }

   /* dla przetestowania funkcji drukuj�cych
      zamiast wstawiac kolejno klucze do drzewa
      zbudujemy "r�cznie" drzewo
             5
            / \
           3   8
              / \
             6   9
      z czerwonym wezlem 8.
      Drukowanie po dolaczeniu kolejnych wezlow.
      Trzeba naciskac ENTER zeby isc dalej
*/
     /*
     Wskwezla korzen,w5,w3,w8,w6,w9;
     korzen=nil;
     drukuj(korzen);
     drukujDot(korzen);
     getchar();

     w5=nowyWezel(5,BLACK);
     korzen=w5;
     drukuj(korzen);
     drukujDot(korzen);
     getchar();

     w3=nowyWezel(3,BLACK);
     w3->p = w5; w5->left = w3;
     drukuj(korzen);
     drukujDot(korzen);
     getchar();

     w8=nowyWezel(8,RED);
     w5->right = w8; w8->p = w5;
     drukuj(korzen);
     drukujDot(korzen);
     getchar();

     w6=nowyWezel(6,BLACK);
     w9=nowyWezel(9,BLACK);
     w8->right = w9; w9->p = w8;
     w8->left = w6; w6->p = w8;

     getchar();
     */
     return 0;
}
