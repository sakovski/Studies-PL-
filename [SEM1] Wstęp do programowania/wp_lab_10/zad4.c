#include<stdio.h>
#include<string.h>

int main(void)
{
  char wyraz[21];
  int n;
  int i;
  puts("Podaj wyraz maksymalnie 20-literowy");
  scanf("%20s", wyraz);
  n=strlen(wyraz);
  puts("Slowo po przeksztalceniu:");
  for(i=0;i<n;i=i+3)
  {
    printf("%c", wyraz[i]);
  }
  printf("\n");
  return 0;
}
