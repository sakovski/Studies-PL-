#include <stdio.h>

int main(void)
{
  char tab[99];
  char *zdanie;
  FILE *plik=fopen("in1.txt","r");
  
  zdanie=fgets(tab,99,plik);
    printf("%s\n",zdanie);
    fclose(plik);
  return 0;
}
