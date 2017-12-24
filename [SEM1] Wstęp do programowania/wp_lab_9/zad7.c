#include <stdio.h>

int main(void)
{
  FILE *plik1=fopen("in1.txt", "r");
  FILE *plik2=fopen("out2.txt", "w");
  char napis[99];
  fgets(napis,99,plik1);
  fprintf(plik2,"%s",napis); 
  fclose(plik1);
  fclose(plik2);
  return 0;
}
