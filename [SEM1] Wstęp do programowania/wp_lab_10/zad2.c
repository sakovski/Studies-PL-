#include<stdio.h>
#include<stdlib.h>
#include<time.h>

int main(void)
{
  int a=0; //prawda/falsz
  int i;
  int tab[10];
  for(i=0;i<10;i++)
  {
    printf("Podaj liczbe nr %d\n", i+1);
    scanf("%d", &tab[i]);
  }
  srand(time(NULL));
  int x=rand() % 10;
  printf("Wylosowana liczba to %d\n", x);
  for(i=0;i<10;i++)
  {
    if(x==tab[i])
      a=1;
  }
  if(a==1)
  {
    int suma=0;
    int j;
    for(j=0;j<10;j++)
    {
       suma=suma+tab[j];
    }
    printf("Znalazlem element w tablicy. Suma liczb w tablicy wynosi %d\n", suma);
  }
  else
    puts("Liczby nie ma w tablicy. Nic nie robie");
  return 0;
}
