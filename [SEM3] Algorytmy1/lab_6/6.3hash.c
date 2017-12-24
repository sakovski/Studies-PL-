//hashowanie [S+OD]


#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define M 100 // wielkosc tab
#define A 0.8 // poziom wypelnienia tab
#define MAXD 44 // maks. dlugosc nazwiska

// struktura dane z iloscia i nazwiskiem
typedef struct dane {
        char nazwisko[MAXD];
        int ilosc;
} dane;

dane T[M]; // tablica z hashowaniem
int iloscProb = 0;
int iloscSzuk = 0;

void zerowanie()
{
        int i;
        for(i=0; i<M; i++)
            strcpy(T[i].nazwisko,"");
}

int haszowanie(char *s, int x)
{
        int dlugosc = strlen(s);
        int i, kluczint = 0;
        for(i = 0; i < dlugosc-1; i=i+2) {
                kluczint ^= ((256*s[i])+s[i+1]);  //konwersja napisu na liczbe
        }
        if(s[i]!=0) {
                kluczint ^= (256*s[i]);
        }

		if(kluczint < 0){
			printf("Blad hashowania\nUjemna wartosc dla wyrazu '%s'\n", s);
			return -1;
		}
        return (int)((kluczint + x*(1+(kluczint%(M-2)))) % M);   //haszowanie podwojne
}

int HaszhInsert(dane T[], dane x){
        // wstawia element x do tablicy z haszowaniem t

        int j;
        int i = 0; // numer proby
        do {
                j = haszowanie(x.nazwisko, i);
                if(j<0){
          				printf("Wyrazu nie wstawiono\n\n");
                  return -1;
                }
                if(strcmp(T[j].nazwisko,"")==0) {
                        T[j] = x;
                        return j;
                }
                i++;
        } while(i<M);

        printf("Brak miejsca!\n");
        return -1;
}

int HaszhSearch(dane T[], char k[]){
  // szuka klucza k w tablicy z hashowaniem
  iloscSzuk++;
  int i = 0;
  int j;
  do{
    iloscProb++;
    j = haszowanie(k,i);
	if(j<0){
		printf("Klucz '%s' nieznaleziony, prob:%d \n", k, i+1);
		return -1;
	}
    if(strcmp(T[j].nazwisko,k)==0){
      printf("Klucz '%s' znaleziony przy probie nr %d.\n",k,i+1);
      return j; // znaleziony klucz
    }
    i++;
  }while(strcmp(T[j].nazwisko,"")!=0 && i<M);
  printf("Klucz '%s' nieznaleziony, prob: %d prob\n",k, i+1);
  return -1;
}

int main(){
  int n=0; // ilosc napisow
  int p; // pomocnicza
  int i;
  dane x;
  zerowanie();

  // otwieranie pliku
  FILE *plik;
  if((plik = fopen("nazwiska.txt", "r"))==NULL){
    printf("Nie moge otworzyc pliku\n");
    exit(1);
  }

  //wypelnienie tab do 80%
  while(n<M*A){
    fscanf(plik,"%d",&x.ilosc);
    fscanf(plik,"%s",x.nazwisko);
    p = HaszhInsert(T,x);
    n++;
  }
  printf("Rozmiar tablicy: %d\n", M);
  printf("Wstawiono %d napisow.\n",n);

  fclose(plik);

  printf("Tablica:::WYDRUK\n");
  for(i = 0; i<M; i++)
    printf("%d: %d %s\n",i,T[i].ilosc,T[i].nazwisko);

  HaszhSearch(T, "Duda");
  HaszhSearch(T, "Dudek");
  HaszhSearch(T, "Krol");
  HaszhSearch(T, "Kopec");
  HaszhSearch(T, "Kruk");

  printf("\nOgolna ilosc szukan:%d, ilosc prob: %d\n", iloscSzuk, iloscProb);
  printf("Wspolczynnik wypelnienia %3.2f\nWspolczynnik wyszukiwan: %3.2f\n\n",
  A,((float)iloscProb/iloscSzuk));

  return 0;
}
