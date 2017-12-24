//Wzkazniki_poczatek

#include <stdio.h>
int main(void)
{
  int x=3;
  int *wsk = &x;
  printf("Zawartosc zmiennej wskaznikowej- %p. Wartosc zmiennej typu int- %d\n", wsk, x); //sposob tradycyjny
  printf("Zawartosc zmiennej wskaznikowej- %d. Wartosc zmiennej typu int- %d\n", *wsk, x); //operator wyluskania 



return 0;
}
