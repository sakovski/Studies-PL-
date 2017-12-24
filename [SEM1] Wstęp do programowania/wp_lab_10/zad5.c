#include<stdio.h>

float srednia(int);
float suma(int);
float iloczyn(int);

int main(void)
{
  int x;
  int n;
  puts("Jezeli chcesz obliczyc sume liczb wsicnij 1.");
  puts("Jezeli chcesz obliczyc iloczyn liczb wcisnij 2.");
  puts("Jezeli chcesz obliczyc srednia liczb wcisnij 3.");
  scanf("%d", &x);
  if(x<1 || x>3)
    puts("Brak takiej opcji w menu");
  switch(x)
  {
    case 1:
      puts("Podaj ile zmiennych chcesz wpisac");
      scanf("%d", &n);
      printf("Suma tych liczb wynosi %.2f\n", suma(n));
    break;
    case 2:
      puts("Podaj ile zmiennych chcesz wpisac");
      scanf("%d", &n);
      printf("Iloczyn tych liczb wynosi %.2f\n", iloczyn(n));
    break;
    case 3:
      puts("Podaj ile zmiennych chcesz wpisac");
      scanf("%d", &n);
      printf("Srednia tych liczb wynosi %.2f\n", srednia(n));
    break;
  }
  return 0;
}
float suma(int n)
{
  float tab[n];
  int i;
  float sm=0;
  for(i=0;i<n;i++)
  {
    printf("Podaj wartosc nr %d\n", i+1);
    scanf("%f", &tab[i]);
    if(tab[i]==0)
    {
      int j;
      for(j=2;j>1;j++)
      {
        puts("Nie mozna podac wartosci 0. Podaj ja jeszcze raz");
        scanf("%f", &tab[i]);
        if(tab[i]!=0)
          j=0;
      }
    }
    sm=sm+tab[i];
  }
  return sm;
}

float iloczyn(int n)
{
  float tab[n];
  int i;
  float il=1;
  for(i=0;i<n;i++)
  {
    printf("Podaj wartosc nr %d\n", i+1);
    scanf("%f", &tab[i]);
    if(tab[i]==0)
    {
      int j;
      for(j=2;j>1;j++)
      {
        puts("Nie mozna podac wartosci 0. Podaj ja jeszcze raz");
        scanf("%f", &tab[i]);
        if(tab[i]!=0)
          j=0;
      }
    }
    il=il*tab[i];
  }
  return il;
}

float srednia(int n)
{
  float tab[n];
  int i;
  float sumsrd=0;
  for(i=0;i<n;i++)
  {
    printf("Podaj wartosc nr %d\n", i+1);
    scanf("%f", &tab[i]);
    if(tab[i]==0)
    {
      int j;
      for(j=2;j>1;j++)
      {
        puts("Nie mozna podac wartosci 0. Podaj ja jeszcze raz");
        scanf("%f", &tab[i]);
        if(tab[i]!=0)
          j=0;
      }
    }
    sumsrd=sumsrd+tab[i];
  }
  return sumsrd/n;
}
