//wskazniki_srednia

#include <stdio.h>
int main(void)
{
  int i;
  int tab[4];
  double suma = 0;
  for(i=0; i<=4; i++)
  {
    printf("Podaj %d. liczbe.\n", i+1);
    int *wsk = &tab[i];
    scanf("%d", &tab[i]); //A tu moze byc po prostu tab + i
    suma += *wsk;    //Mozna tez nie deklarowac *wsk, i tu po prostu wpisac *(tab+i)
  }
  float srednia = suma/5;
  printf("Srednia z tych 5 liczb wynosi %f", srednia);

return 0;
}
