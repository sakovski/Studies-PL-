#include <stdio.h>
#include <string.h>
int main(void)
{
  char slowo[100];
  char slowo2[100];
  int klucz, i, n;
  puts("Podaj slowo do zaszyfrowania.");
  scanf("%99s", slowo);
  n = strlen(slowo);
  puts("Podaj klucz");
  scanf("%d", &klucz);
  for(i=0; i<n; i++)
  {
    slowo2[i] = slowo[i] + klucz;
  }
  printf("Slowo po zaszyfrowaniu to %s\n", slowo2);



return 0;
}
