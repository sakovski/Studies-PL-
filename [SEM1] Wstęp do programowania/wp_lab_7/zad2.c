//Wskazniki_tablica

#include <stdio.h>
int main(void)
{
  int tab[9];
  int i;
  for(i=0; i<=9; i++)
  {
    int *wsk = &tab[i];
    printf("Adres %d. elementu- %p\n", i+1, wsk);
  }


return 0;
}
