//wskazniki_odwrocenie

#include <stdio.h>
#include <string.h>
int main(void)
{
  char wyraz[100];
  puts("Podaj wyraz, a program go odwroci.");
  scanf("%99s", wyraz);
  int n = strlen(wyraz);
  int i;
  for(i=n-1; i>=0; i--)
  {
   printf("%c", *(wyraz + i));
  }
  printf("\n");
  return 0;
}
