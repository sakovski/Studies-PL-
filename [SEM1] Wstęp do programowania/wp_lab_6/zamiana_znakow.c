#include <stdio.h>
#include <string.h>
int main(void)
{
  int i;
  int n;
  char znaki[100];
  printf("Wpisz slowo malymi literami, a program zamieni je na wielkie.\n");
  scanf("%99s", znaki);
  n = strlen(znaki);
  for(i=0; i<n; i++)
  {
    znaki[i] = znaki[i] - 32;
  }
  printf("Slowo po zamianie to %s\n", znaki);
  return 0;
}
