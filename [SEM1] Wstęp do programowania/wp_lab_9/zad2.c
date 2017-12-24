#include <stdio.h>

int main(void)
{
  int a;
  FILE* plik1 = fopen("in.txt", "r");
  FILE* plik2 = fopen("out.txt", "w");
  int i;
  for(i=0;i<20;i++)
  {
    fscanf(plik1,"%d",&a);
    fprintf(plik2,"%d\n",a);
  }
  fclose(plik1);
  fclose(plik2);
  return 0;
}
