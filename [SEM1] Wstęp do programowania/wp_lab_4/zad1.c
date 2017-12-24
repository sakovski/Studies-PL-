#include <stdio.h>
int main()
{
float r, d;
printf("Podaj promien sfery\n");
scanf("%f", &r);
printf("Podaj odleglosc miedzy srodkami sfer.\n");
scanf("%f", &d);
double pi = 3.141592654;
double S = pi * (r * r - (d*d/4));
printf("Pole kola wynosi %lf\n", S);

return 0;
}
