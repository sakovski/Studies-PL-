#include<stdio.h>
#include<stdlib.h>
#include<time.h>



int main(void)
{
  char pesel[12];
  int poprawny;
  char plec;
  puts("Wprowadz numer PESEL");
  scanf("%s", pesel);
  if(pesel[9]%2==0)
    puts("Jestes kobieta");
  else
    puts("Jestes mezczyzna");


  return 0;
}

int czypoprawny(char pes[])
{
  int tab[10]={1,3,7,9,1,3,7,9,1,3};
  int suma=0;
  int a;
  for(a=0;a<10;a++)
  {
    suma=suma+(tab[a]*(pes[a]);
  }
  int ctrl=suma%10;
  ctrl=10

