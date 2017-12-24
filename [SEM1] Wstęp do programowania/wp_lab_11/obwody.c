#include<stdio.h>
#include<stdlib.h>
#include<math.h>

void Obwkwa(void)
{
  puts("Podaj dlugosc boku kwadratu");
  float a;
  scanf("%f", &a);
  printf("Obwod tego kwadratu wynosi %f \n", 4*a);
}

void Obwpro(void)
{
  float a, b;
  puts("Podaj dlugosc krotszego boku prostokata");
  scanf("%f", &a);
  puts("Podaj dlugosc dluzszego boku prostokata");
  scanf("%f", &b);
  printf("Obwod tego prostokata wynosi %f \n", 2*a+2*b);
}

void Obwtro(void)
{
  float a, b, c;
  puts("Podaj dlugosc pierwszego boku trojkata");
  scanf("%f", &a);
  puts("podaj dlugosc drugiego boku trojkata");
  scanf("%f", &b);
  puts("Podaj dlugosc trzeciego boku trojkata");
  scanf("%f", &c);
  printf("Obwod tego trojkata wynosi %f \n", a+b+c);
}

void Obwkol(void)
{
  float pi=3.14;
  float r;
  puts("Podaj promien kola");
  scanf("%f", &r);
  printf("Obwod tego kola wynosi %f \n", 2*pi*r);
}

void Obwtra(void)
{
  float a, b, c, d;
  puts("Podaj dlugosc dluzszej podstawy trapezu");
  scanf("%f", &a);
  puts("Podaj dlugosc krotszej podstawy trapezu");
  scanf("%f", &b);
  puts("Podaj dlugosc pierwszego boku trapezu");
  scanf("%f", &c);
  puts("Podaj dlugosc drugiego boku trapezu");
  scanf("%f", &d);
  printf("Obwod tego trapezu wynosi %f \n", a+b+c+d);
}

void Obwrom(void)
{
  float a;
  puts("Podaj dlugosc boku rombu");
  scanf("%f", &a);
  printf("Obwod tego rombu wynosi %f \n", 4*a);
}

void Obwrow(void)
{
  float a, b;
  puts("Podaj dlugosc krotszego boku rownolegloboku");
  scanf("%f", &a);
  puts("Podaj dlugosc dluzszego boku rownolegloboku");
  scanf("%f", &b);
  printf("Obwod tego rownolegloboku wynosi %f \n", 2*a+2*b);
}
