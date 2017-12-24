#include<stdio.h>
#include<math.h>
#include<stdlib.h>

void Objgraczw(void)
{
  float a, h;
  puts("Podaj dlugosc krawedzi podstawy graniastoslupa");
  scanf("%f", &a);
  puts("Podaj dlugosc wysokosci graniastoslupa");
  scanf("%f", &h);
  printf("Objetosc tego graniastoslupa prawidlowego czworokatnego wynosi %f \n", a*a*h);
}

void Objgratro(void)
{
  float a, h;
  puts("Podaj dlugosc krawedzi podstawy graniastoslupa");
  scanf("%f", &a);
  puts("Podaj dlugosc wysokosci graniastoslupa");
  scanf("%f", &h);
  printf("Objetosc tego graniastoslupa prawidlowego trojkatnego wynosi %.2f \n", ((sqrt(3)*a*a)/4)*h);
}

void Objgrasze(void)
{
  float a, h;
  puts("Podaj dlugosc krawedzi podstawy graniastoslupa");
  scanf("%f", &a);
  puts("Podaj dlugosc wysokosci graniastoslupa");
  scanf("%f", &h);
  printf("Objetosc tego graniastoslupa prawidlowego szesciokatnego wynosi %.2f \n", 6*((sqrt(3)*a*a)/4)*h);
}

void Objostczw(void)
{
  float a, h;
  puts("Podaj dlugosc krawedzi podstawy ostroslupa");
  scanf("%f", &a);
  puts("Podaj dlugosc wysokosci ostroslupa");
  scanf("%f", &h);
  printf("Objetosc tego ostroslupa prawidlowego czworokatnego wynosi %f \n",((a*a)/3)*h);
}

void Objosttro(void)
{
  float a, h;
  puts("Podaj dlugosc krawedzi podstawy ostroslupa");
  scanf("%f", &a);
  puts("Podaj dlugosc wysokosci ostroslupa");
  scanf("%f", &h);
  printf("Objetosc tego ostroslupa prawidlowego trojkatnego wynosi %.2f \n", ((sqrt(3)*a*a)/12)*h);
}

void Objostsze(void)
{
  float a, h;
  puts("Podaj dlugosc krawedzi podstawy ostroslupa");
  scanf("%f", &a);
  puts("Podaj dlugosc wysokosci ostroslupa");
  scanf("%f", &h);
  printf("Objetosc tego ostroslupa prawidlowego szesciokatnego wynosi %.2f \n", 6*((sqrt(3)*a*a)/12)*h);
}

void Objwal(void)
{
  float r, h;
  float pi=3.14;
  puts("Podaj dlugosc promienia podstawy walca");
  scanf("%f", &r);
  puts("Podaj dlugosc wysokosci walca");
  scanf("%f", &h);
  printf("Objetosc tego walca wynosi %f \n", pi*r*r*h);
}

void Objsto(void)
{
  float r, h;
  float pi=3.14;
  puts("Podaj dlugosc promienia podstawy stozka");
  scanf("%f", &r);
  puts("Podaj dlugosc wysokosci stozka");
  scanf("%f", &h);
  printf("Objetosc tego stozka wynosi %f \n", (pi*r*r*h)/3);
}

void Objkul(void)
{
  float r;
  float pi=3.14;
  puts("Podaj dlugosc promienia kuli");
  scanf("%f", &r);
  printf("Objetosc tej kuli wynosi %f \n", (4*(pi*r*r*r))/3);
}
