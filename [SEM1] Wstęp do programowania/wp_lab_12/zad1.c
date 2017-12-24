#include<stdio.h>
#include<stdlib.h>
#include<time.h>

int main(void)
{
  srand( time( NULL ) );
  char tekst[10][50];
  FILE *plik=fopen("slowa.txt",  "r");
  int ls;
  puts("Podaj ile slow chcesz pobrac");
  scanf("%d", &ls);
  int ind;
  int j=0;
  while(fgets(tekst[j], 50, plik) != NULL)
  {
      ind=rand() % 5;
      fgets(tekst[ind],50,plik);
      printf("%s",tekst[ind]);
      j++;
  }

  fclose(plik);
  return 0;
}
