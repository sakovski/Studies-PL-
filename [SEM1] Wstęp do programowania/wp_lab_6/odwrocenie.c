#include <stdio.h>
#include <string.h>
int main()
{
  int n, i, j;
  char slowo[100];
  puts("Podaj slowo");
  scanf("%99s", slowo);
  n = strlen(slowo);
  printf("Odwrocone slowo brzmi: ");
  for(i=n-1; i>=0; i--)
  {
  printf("%c", slowo[i]);
  }
  printf("\n");
  for(j=0;j<n;j++)
  {
    if(slowo[j] == slowo[n-1])
      n=n-1;
    else
    {
      puts("Slowo nie jest palindromem");
      break;
    }
  }
  if(j>=n)
    puts("Slowo jest palindromem");
 return 0;
}
