

#include <stdio.h>
#include <stdlib.h>

int main(void)
{
  int n;
  puts("Podaj liczbe komorek pamieci ktore chcesz zaalokowac");
  scanf("%d", &n);
  int *x;
  x=(int*)malloc(n*sizeof(n));
  int i;
  for(i=0;i<n;i++)
  {
    printf("Podaj wartosc nr %d\n", i+1);
    scanf("%d", x+i);
  }
  for(i=0;i<n;i++)
  {
    printf("Wartosc nr %d to: %d", i+1, *(x+i));
    printf("\n");
  }
  free(x);

  return 0;
}
