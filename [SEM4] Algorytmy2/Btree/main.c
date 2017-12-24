// struktura wezla B-drzewa i przyklad zapisu i odczytu na plik
// budowanie B-drzewa o zadanej wysokosci i drukowanie
//                                         Pawel Paczkowski (C)

#include <stdio.h>
#include <stdlib.h>
#define T 3   // stopien B-drzewa

static int min=T-1;
static int max=(2*T)-1;

typedef struct wezel{
  short n;        //ilosc kluczy (-1 oznacza wezel usuniety)
  short leaf;     // czy lisc (0-nie 1-tak)
  int k[2*T-1];   // klucze
  int c[2*T];     // wskazniki do synow (pozycje w pliku: 0,1,2 ...)
  int pozycja_plik;  // pozycja w pliku
} Wezel;

int rozmiarw = sizeof(Wezel); // rozmiar wezla w bajtach
int pozycja=0; //globalne pozycje w pliku

FILE *drzewoplik;  // plik drzewa (zawierajacy wezly)

typedef struct{
	Wezel *root;
} Drzewo;

void zapisz(int i,Wezel *w){
  // zapisuje *w jako i-ty zapis w pliku drzewa
  fseek(drzewoplik,(long)i*rozmiarw,SEEK_SET);//ustawia pozycje w pliku plik;pozycja;mode
  fwrite(w,rozmiarw,1,drzewoplik); //wsk_na_wezel;rozmiar_elementu_wezla;liczba_elem_do_zapisu;plik
  //  printf("z%d ",i);
}

void odczytaj(int i,Wezel *w){
  // odczytuje i-ty zapis w pliku drzewa i wpisuje do *w
  fseek(drzewoplik,(long)i*rozmiarw,SEEK_SET);
  fread(w,rozmiarw,1,drzewoplik);//wsk_na_wezel;rozmiar_elementu_wezla;liczba_elem_do_zapisu;plik
  //  printf("o%d ",i);
}
/*
void usun(int i){
  // usuwa i-ty zapis w pliku drzewa
  // w tej wersji nie wykorzystujemy usunietych pozycji,
  // tylko zaznaczamy jako usuniete
  Wezel w;
  odczytaj(i,&w);
  w.n=-1;
  zapisz(i,&w);
}
*/
/*int budujB(int g, int n){
  // buduje B-drzewo o wysokosci g, w kazdym wezle jest n kluczy
  // wynikiem jest pozycja korzenia w pliku - jest to ostatni
  // zapis w pliku, co jest wazne dla dalszych zapisow do pliku
  // ktore trzeba robic zaczynajac od kolejnej pozycji
  static int klucz=0; // kolejny klucz
  static int pozycja=0; // wolna pozycja w pliku
  Wezel w;
  w.n=n;
  int i;
  if (g==0){  // lisc
    for (i=0;i<n;i++){
      w.c[i]= -1; // w lisc - brak synow
      w.k[i]= klucz++;
    }
    w.c[n]= -1;
    w.leaf=1; //lisc=true
  }
  else {  // wezel wewnetrzny
    for (i=0;i<n;i++){
      w.c[i]= budujB(g-1,n); //g-1 bo zmniejszamy stopien o 1
      w.k[i]= klucz++;
    }
    w.c[n]= budujB(g-1,n);
    w.leaf=0; //lisc=false
  }
  zapisz(pozycja++,&w);
  return pozycja-1;
}
*/
drukujB(int r, int p)
{
  // drukuje B-drzewo o korzeniu r (pozycja w pliku)
  // wydruk przesuniety o p w prawo
  Wezel w;
  int i,j;
  odczytaj(r,&w);
  if (w.leaf){ //jesli 0 - false(nie lisc), jesli 1 - true(lisc)
    for (i=0;i<p;i++) printf(" ");
    for (i=0;i<w.n;i++) printf("%d ",w.k[i]);
    printf("\n");
  } else {
    drukujB(w.c[w.n],p+4);
    for (i=w.n-1;i>=0;i--){
      for (j=0;j<p;j++) printf(" ");
      printf("%d\n",w.k[i]);
      drukujB(w.c[i],p+4);
    }
  }
}

int szukajWezel(Wezel* x, int szukany) //0 - nieznaleziono, 1 - znaleziono
{
  int i=0;

  while(i<(x->n) && szukany>x->k[i])
  {
    i++;
  }

  if(i<x->n && szukany==x->k[i])
  {
    return 1;
  }
  if(x->leaf==1) //jesli lisc=true
  {
    return 0;
  }
  else
  {
    Wezel temp;
    odczytaj(x->c[i], &temp); //przeszukujemy kolejny wezel(C[i])
    return szukajWezel(&temp, szukany);
  }
}


rozbijWezel(Wezel* ojciec, int i, Wezel* synrozbijany) //i - 0 ojciec-ojciec drzewo-rozbijany
{
  Wezel syn2; //nowopowstaly syn po rozbiciu
  syn2.leaf=synrozbijany->leaf;
  syn2.n=min;
  int j;
  for(j=0; j<min; j++)
  {
    syn2.k[j]=synrozbijany->k[T+j]; //kopiujemy koncowe klucze syna1 na poczatek syna2
  }
  if(synrozbijany->leaf==0) //nie jest lisciem
  {
    for(j=0; j<T; j++) //do T bo synow jest o 1 wiecej niz kluczy
    {
      syn2.c[j]= synrozbijany->c[T+j]; //kopiujemy wskazniki do synow (pozycje w pliku)
    }
  }
  synrozbijany->n=min; //nowy rozmiar syna1
  for(j=ojciec->n; j>=i+1; j--)
  {
    ojciec->c[j+1]= ojciec->c[j]; //rearanzacja synow
  }
    syn2.pozycja_plik = ++pozycja;
    ojciec->c[i+1] = syn2.pozycja_plik; //przypisanie pozycji w pliku

    for(j=ojciec->n-1; j>=i; j--)
    {
        ojciec->k[j+1]= ojciec->k[j]; //rearanzacja kluczy
    }
    ojciec->k[i]= synrozbijany->k[min];
    (ojciec->n)+=1;
    zapisz(synrozbijany->pozycja_plik, synrozbijany);
  	zapisz(syn2.pozycja_plik, &syn2);
  	zapisz(ojciec->pozycja_plik, ojciec);
}

wstawianieZwykle(Wezel *wezel, int klucz)//gdy wezel nie jest przepelniony
{
  int i = wezel->n-1;
  if(wezel->leaf==1) //jesli lisc
  {
      while(i>0 && klucz<wezel->k[i]) //znajduje miejsce do wstawienia klucza
      {
          wezel->k[i+1]= wezel->k[i]; //przesuwa klucze by zrobic miejsce
          i--;
      }
      wezel->k[i+1]= klucz; //wstawienie klucza
      wezel->n+=1;
      zapisz(wezel->pozycja_plik, wezel);
      printf("\nKlucz %d zostal wstawiony pomyslnie\n",klucz);
      return;
  }
  else //nie lisc
  {
      while(i>=0 && klucz<wezel->k[i]) //znajudejemy miejsce w ktorym nalezy wywolac fukncje rekurencyjnie
      {
        i--;
      }
      i++;

      Wezel temp;
      odczytaj(wezel->c[i], &temp);

      if(temp.n==max)
      {
          rozbijWezel(wezel, i, &temp);//rozbijamy
          if(klucz>wezel->k[i])
          {
            i++;
            odczytaj(wezel->c[i], &temp);
          }
      }
      wstawianieZwykle(&temp,klucz);
  }
}

  wstawianie(Drzewo *drzewo, int klucz)
	{

    Wezel *x=drzewo->root;
		if(x->n == max)//jesli pelny
		{
			Wezel *s = (Wezel*)malloc(sizeof(Wezel)); //nowy wezel

      s->n = 0; //ilosc kluczy
  		s->leaf = 0;
  		s->c[0] = x->pozycja_plik;
  		pozycja++;
  		s->pozycja_plik = pozycja;

      drzewo->root = s; //nowy korzen
  		rozbijWezel(s, 0, x);
  		wstawianieZwykle(s, klucz);
		}
		else
			wstawianieZwykle(x, klucz);//jesli wezel niepelny to wstawianie normalne
	}

main(){

    drzewoplik = fopen("bdrzewo","w+");
    Drzewo drzewo;
    Wezel Tr;
    Tr.n = 0;
    Tr.leaf=1;
    Tr.pozycja_plik = 0;
    drzewo.root = &Tr;
    int i;
    int Test[14] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
    for(i=0; i<14; i++)
    {
      wstawianie(&drzewo, Test[i]);
    }
    printf("\n");
    int main_petla=0;
    int wybor;
    int elem_wybor;
    while(main_petla==0)
    {
      printf("\n1.INSERT \n");
      printf("2.SEARCH \n");
      printf("3.PRINT \n");
      printf("4.DELETE \n");
      printf("5.EXIT \n");
      scanf("%d", &wybor);
      if(wybor==1)
      {
       printf("INSERT ELEMENT: \n");
       scanf("%d", &elem_wybor);
       wstawianie(&drzewo, elem_wybor);
      }
      if(wybor==2)
      {
         printf("SEARCH ELEMENT: \n");
         scanf("%d", &elem_wybor);
         if(szukajWezel(drzewo.root, elem_wybor)==1)
         {
           printf("ZNALEZIONO. \n");
         }
         else
         {
             printf("NIE ZNALEZIONO. \n");
         }
      }
      if(wybor==3)
      {
         drukujB(drzewo.root->pozycja_plik,0);
      }
      if(wybor==4)
      {

      }
      if(wybor==5)
      {
        break;
      }
    }
    fclose(drzewoplik);
}
