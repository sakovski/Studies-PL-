
#include<stdio.h>
#include<stdlib.h>
#include<time.h>

int main(void)
{
  srand( time( NULL ) );
  char tekst[10][50];
  FILE *plik=fopen("slowa.txt",  "r");
  int ind;
  int i;
  for(i=0; i<5; i++);
  {
    fgets(tekst[i], 50, plik);
  }
  int ls;
  puts("Podaj ile slow chcesz pobrac");
  scanf("%d", &ls);
  int j;
  for(j=0; j<ls; j++)
  {
    ind=rand() % 5;
    printf("%s", tekst[ind]);
  }
  fclose(plik);
  return 0;
}

