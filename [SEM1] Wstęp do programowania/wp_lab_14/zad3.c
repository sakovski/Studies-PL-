#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int main(void)
{
  puts("Podaj slowo skladajace sie z parzystej liczby liter");
  char slowo[99];
  scanf("%s", slowo);
  int l=strlen(slowo);
  if(l%2!=0)
  {
    puts("Miales podac slowo skladajace sie z parzystej liczby liter!!!");
    return -1;
  }
  int i, temp;
  for(i=0; i<l; i=i+2)
  {
    temp=slowo[i];
    slowo[i]=slowo[i+1];
    slowo[i+1]=temp;
  }
  printf("Slowo po odwroceniu to %s \n", slowo);

  return 0;
}

