#include<stdio.h>
#include<stdlib.h>
#include<math.h>

void Polgraczw(void)
{
  float a, b;
  puts("Podaj dlugosc krawedzi podstawy graniastoslupa");
  scanf("%f", &a);
  puts("Podaj dlugosc krawedzi bocznej graniastoslupa");
  scanf("%f", &b);
  printf("Pole powierzchni tego graniastoslupa prawidlowego czworokatnego wynosi %f \n", 2*a*a+4*a*b);
}

void Polgratro(void)
{
  float a, b;
  puts("Podaj dlugosc krawedzi podstawy graniastoslupa");
  scanf("%f", &a);
  puts("Podaj dlugosc krawedzi bocznej graniastoslupa");
  scanf("%f", &b);
  printf("Pole powierzchni tego graniastoslupa prawidlowego trojkatnego wynosi %.2f \n", 2*((sqrt(3)*a*a)/4)+3*a*b);
}

void Polgrasze(void)
{
  float a, b;
  puts("Podaj dlugosc krawedzi podstawy graniastoslupa");
  scanf("%f", &a);
  puts("Podaj dlugosc krawedzi bocznej graniastoslupa");
  scanf("%f", &b);
  printf("Pole powierzchni tego graniastoslupa prawidlowego szesciokatnego wynosi %.2f \n", 2*6*((sqrt(3)*a*a)/4)+6*a*b);
}

void Polostczw(void)
{
  float a, h;
  puts("Podaj dlugosc krawedzi podstawy ostroslupa");
  scanf("%f", &a);
  puts("Podaj dlugosc wysokosci sciany bocznej ostroslupa");
  scanf("%f", &h);
  printf("Pole powierchni tego ostroslupa prawidlowego czworokatnego wynosi %f \n", a*a+4*((a*h)/2));
}

void Polosttro(void)
{
  float a, h;
  puts("Podaj dlugosc krawedzi podstawy ostroslupa");
  scanf("%f", &a);
  puts("Podaj dlugosc wysokosci sciany bocznej ostroslupa");
  scanf("%f", &h);
  printf("Pole powierchni tego ostroslupa prawidlowego trojkatnego wynosi %.2f \n", (sqrt(3)*a*a)/4+3*((a*h)/2));
}

void Polostsze(void)
{
  float a, h;
  puts("Podaj dlugosc krawedzi podstawy ostroslupa");
  scanf("%f", &a);
  puts("Podaj dlugosc wysokosci sciany bocznej ostroslupa");
  scanf("%f", &h);
  printf("Pole powierzchni tego ostroslupa prawidlowego szesciokatnego wynosi %.2f \n", 6*(sqrt(3)*a*a)/4+6*((a*h)/2));
}

void Polwal(void)
{
  float r, h;
  float pi=3.14;
  puts("Podaj dlugosc promienia podstawy walca");
  scanf("%f", &r);
  puts("Podaj dlugosc krawedzi bocznej walca");
  scanf("%f", &h);
  printf("Pole powierzchni tego walca wynosi %f \n", 2*pi*r*r+h*2*pi*r);
}

void Polsto(void)
{
  float l, r;
  float pi=3.14;
  puts("Podaj dlugosc promienia podstawy stozka");
  scanf("%f", &r);
  puts("Podaj dlugosc tworzacej stozka");
  scanf("%f", &l);
  printf("Pole powierzchni tego stozka wynosi %f \n", pi*r*r+pi*r*l);
}

void Polkul(void)
{
  float r;
  float pi=3.14;
  puts("Podaj promien kuli");
  scanf("%f", &r);
  printf("Pole powierzchni tej kuli wynosi %f \n", 4*pi*r*r);
}
