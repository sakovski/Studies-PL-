//Wskazniki_tablica_suma

#include <stdio.h>
int main(void)
{
  int i;
  int tab[4];
  int suma = 0;
  for(i=0; i<=4; i++)
  {
    printf("Podaj %d liczbe\n", i+1);
    int *wsk = &tab[i];
    scanf("%d", &tab[i]);
    suma += *wsk;
  }
  printf("Suma tych liczb wynosi %d", suma);
  return 0;
}
