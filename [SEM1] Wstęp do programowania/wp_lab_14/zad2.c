#include<stdio.h>
#include<stdlib.h>

int main(void)
{
  FILE *plik=fopen("liczby.txt", "r");
  FILE *plik2=fopen("wynik.txt", "w");
  puts("Podaj liczbe, a ja sprawdze, czy jest ona w pliku liczby.txt");
  int n, l, i;
  int licznik=0;
  scanf("%d", &n);
  for(i=0;i<57;i++)
  {
    fscanf(plik, "%d", &l);
    if(l==n)
      licznik++;
  }
  char *napis="Liczba x wystepuje w pliku n razy";
  fprintf(plik2, "Liczba %d wystepuje w pliku %d razy",n,licznik); 


  fclose(plik);
  fclose(plik2);
  return 0;
}
