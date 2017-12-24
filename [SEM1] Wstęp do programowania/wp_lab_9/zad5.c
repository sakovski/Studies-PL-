#include <stdio.h>
#include <time.h>
#include <stdlib.h>

int main(void)
{
  FILE *plik=fopen("lotto.txt","w");
  int tab[20];
  srand(time(0));
  int i;
  for(i=0;i<20;i++)
  {
    tab[i]=rand()%100;
    fprintf(plik,"%d\n",tab[i]);
  }
  return 0;
}
