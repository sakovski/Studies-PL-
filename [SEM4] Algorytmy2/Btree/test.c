// struktura wezla B-drzewa i przyklad zapisu i odczytu na plik
// budowanie B-drzewa o zadanej wysokosci i drukowanie
//                                         Pawel Paczkowski (C)

#include <stdio.h>
#define T 3   // stopien B-drzewa

typedef struct{
  short n;        //ilosc kluczy (-1 oznacza wezel usuniety)
  short leaf;     // czy lisc (0-nie 1-tak)
  int k[2*T-1];   // klucze
  int c[2*T];     // wskazniki do synow (pozycje w pliku: 0,1,2 ...)
  int info[2*T-1];  // wskazniki do informacji skojarzonej z kluczem
                    // (pozycje w innym pliku); tutaj nie beda uzyte
} Wezel;

int rozmiarw = sizeof(Wezel); // rozmiar wezla w bajtach

FILE *drzewo;  // plik drzewa (zawierajacy wezly)

void zapisz(int i,Wezel *w){
  // zapisuje *w jako i-ty zapis w pliku drzewa
  fseek(drzewo,(long)i*rozmiarw,SEEK_SET);//ustawia pozycje w pliku plik;pozycja;mode
  fwrite(w,rozmiarw,1,drzewo); //wsk_na_wezel;rozmiar_elementu_wezla;liczba_elem_do_zapisu;plik
  //  printf("z%d ",i);
}

void odczytaj(int i,Wezel *w){
  // odczytuje i-ty zapis w pliku drzewa i wpisuje do *w
  fseek(drzewo,(long)i*rozmiarw,SEEK_SET);
  fread(w,rozmiarw,1,drzewo);//wsk_na_wezel;rozmiar_elementu_wezla;liczba_elem_do_zapisu;plik
   // printf("o%d ",i);
}

void usun(int i){
  // usuwa i-ty zapis w pliku drzewa
  // w tej wersji nie wykorzystujemy usunietych pozycji,
  // tylko zaznaczamy jako usuniete
  Wezel w;
  odczytaj(i,&w);
  w.n=-1;
  zapisz(i,&w);
}

int budujB(int g, int n){
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
/*
int szukajWezel(int elem, Wezel *w)//0-nieznaleziono, 1-znaleziono
{
  int i;
  for(i=0;i<w.n;i++)
  {
    if(elem==w.k[i])
    {
      return 1;
    }
  }
  return 0;
}

int szukajB(int elem, int root) //1-znaleziono, 0-nieznalezino
{
  Wezel w;
  int i,j;
  odczytaj(root,&w);
  if (w.leaf){ //jesli 0 - false(nie lisc), jesli 1 - true(lisc)
    if(szukajWezel(elem, &w)==1)
    {
      return 1;
    }
  } else {
    szukajB(elem,w.c[w.n]);
    for (i=w.n-1;i>=0;i--){
      szukajB(elem,w.c[i]);
    }
  }

}
*/
main(){
    int i;
    double sp;
    drzewo = fopen("bdrzewo","w+");
    Wezel wezel;
    int root;

    root=budujB(2,2);
    printf("ROOT:%d \n", root);
    drukujB(root,0);
    fclose(drzewo);
}
