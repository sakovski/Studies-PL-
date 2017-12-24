 //dodaj oraz dodaj_wsk

#include <stdio.h>

int dodaj(int);
int dodaj_wsk(int*);

int main(void)
{
  int y;
  int x=4;
  y=dodaj(x);
  printf("Teraz %d ma wartosc\n", x);
  y=dodaj_wsk(&x);
  printf("A teraz %d ma wartosc\n", x);

  return 0;
}

int dodaj(int x)
{
  x=x+5;
  return x;
}

int dodaj_wsk(int *x)
{
  *x=*x+5;
  return *x;
}
