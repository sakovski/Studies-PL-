#include <stdio.h>

int main(void)
{
  
  int tab[20];
  FILE *plik;
  plik=fopen("in.txt", "r");
  int i;
  for(i=0;i<20;i++)
  {
    fscanf(plik,"%d",&tab[i]);
  }
  fclose(plik);
  for(i=0;i<20;i++)
  {
    printf("%d\n", tab[i]);
  }
  return 0;
}
