#include <stdio.h>

int main(void)
{
  FILE *plik=fopen("in.txt", "r");
  int suma=0;
  int i;
  int a;
  for(i=0;i<20;i++)
  {
    fscanf(plik,"%d",&a);
    suma=suma+a;
  }
  fclose(plik);
  printf("Suma liczb wynosi: %d\n",suma);
  return 0;
}
