#include<stdio.h>

int main(void)
{
  int tab[16];
  int i;
  int parz=0;
  int p5=0;
  int p7=0;
  for(i=0;i<16;i++)
  {
    printf("Podaj liczbe nr %d\n", i+1);
    scanf("%d", &tab[i]);
  }
  for(i=0;i<16;i++)
  {
    if(tab[i]%2==0)
      parz++;
    if(tab[i]%5==0)
      p5++;
    if(tab[i]%7==0)
      p7++;
  }
  printf("Podales %d liczb parzystych\n", parz);
  printf("Podales %d liczb podzielnych przez 5\n", p5);
  printf("Podales %d liczb podzielnych przez 7\n", p7);
 return 0;
}
