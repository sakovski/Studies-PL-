#include<stdio.h>
int powIt(int, int);
int powRek(int, int);
int n, a, i, w;
int main(void)
{
  puts("Podaj liczbe a i n-ta potege, do ktorej ma byc podniesiona. Oddziel je spacja.");
  scanf("%d %d", &a, &n);
  puts("Jesli chcesz policzyc potege iteracyjnie, wpisz 1.");
  puts("Jesli chcesz policzyc potege rekurencyjnie, wpisz 2.");
  scanf("%d", &w);
  switch(w)
  {
  case 1:
    powIt(a, n);
    break;
  case 2:
    powRek(a, n);
    printf("Wynik: %d\n", powRek(a, n));
    break;
  }
  return 0;
}

int powIt(int a, int n)
{
  int liczba = a;
  for(i=1;i<n;i++)
  {
    a = a * liczba;
  }
  printf("Wynik: %d\n", a);
  return a;
}

int powRek(int a, int n)
{
  if(n == 0)
    return 1;
  else
    return powRek(a,n-1)*a;
}
