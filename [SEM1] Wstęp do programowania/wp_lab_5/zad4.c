#include <stdio.h>
int sprawdz(int, float);
int silniaIt(float, int, int);
int silniaRek(float);
float liczba = 0;
int silnia = 1;
int n, x, i;
int main(void)
{
puts("Podaj liczbe calkowita od 1 do 10, z ktorej chcesz obliczyc silnie");
scanf("%f", &liczba);
sprawdz(x, liczba);
puts("Jezeli chcesz obliczyc silnie iteracyjnie wpisz 1.");
puts("Jezeli chcesz obliczyc silnie rekurencyjnie wpisz 2.");
scanf("%d", &n);
switch(n)
{
case 1:
  silniaIt(liczba, i, silnia);
  break;
case 2:
  silniaRek(liczba);
  printf("Silnia z %.0f wynosi %d.\n", liczba, silniaRek(liczba));
  break;
}
return 0;
}

int sprawdz(int x, float liczba)
{
  x = liczba;
  if(liczba==x && liczba>0 && liczba<11)
  {
    puts("Podales prawidlowa liczbe.");
  }
  else
  {
    puts("Podales bledna liczbe.");
  }
  return liczba;
}

int silniaIt(float liczba, int i, int silnia)
{
  for(i=1;i<=liczba;i++)
  {
    silnia = silnia * i;
  }
  printf("Silnia z %.0f wynosi %d.\n", liczba, silnia);
  return silnia;
}

int silniaRek(float liczba)
{
  if(liczba == 0 || liczba == 1)
  {
  return 1;
  }
  else
  {
  return silniaRek(liczba-1) * liczba;
  }
}
