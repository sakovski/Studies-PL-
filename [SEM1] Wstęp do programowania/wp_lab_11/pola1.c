#include<stdio.h>
#include<stdlib.h>
#include<math.h>

void Polkwa(void)
{
  float a;
  puts("Podaj dlugosc boku kwadratu");
  scanf("%f", &a);
  printf("Pole tego kwadratu wynosi %f \n", a*a);
}

void Polpro(void)
{
  float a, b;
  puts("Podaj dlugosc krotszego boku prostokata");
  scanf("%f", &a);
  puts("Podaj dlugosc dluzszego boku prostokata");
  scanf("%f", &b);
  printf("Pole tego prostokata wynosi %f \n", a*b);
}

void Poltro(void)
{
  float a, h;
  puts("Podaj dlugosc podstawy trojkata");
  scanf("%f", &a);
  puts("Podaj dlugosc wysokosci trojkata do tej podstawy");
  scanf("%f", &h);
  printf("Pole tego trojkata wynosi %f \n", a*h);
}

void Polkol(void)
{
  float pi=3.14;
  float r;
  puts("Podaj dlugosc promienia kola");
  scanf("%f", &r);
  printf("Pole tego kola wynosi %f \n", pi*r*r);
}

void Poltra(void)
{
  float a, b, h;
  puts("Podaj dlugosc krotszej podstawy trapezu");
  scanf("%f", &a);
  puts("Podaj dlugosc dluzszej podstawy trapezu");
  scanf("%f", &b);
  puts("Podaj dlugosc wysokosci trapezu");
  scanf("%f", &h);
  printf("Pole tego trapezu wynosi %f \n", ((a+b)*h)/2);
}

void Polrom(void)
{
  float a, b;
  puts("Podaj dlugosc krotszej przekatnej rombu");
  scanf("%f", &a);
  puts("Podaj dlugosc dluzszej przekatnej rombu");
  scanf("%f", &b);
  printf("Pole tego rombu wynosi %f \n", (a+b)/2);
}

void Polrow(void)
{
  float a, h;
  puts("Podaj dlugosc podstawy rownolegloboku");
  scanf("%f", &a);
  puts("Podaj dlugosc wysokosci rownolegloboku");
  scanf("%f", &h);
  printf("Pole tego rownolegloboku wynosi %f \n", a*h);
}


