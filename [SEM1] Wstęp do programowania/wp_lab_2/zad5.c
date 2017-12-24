#include <stdio.h>
int main()
{
printf("Zamieniam stopnie Fahrenheita na Celsjusza i vice versa\n");
printf("Jesli chcesz zamienic stopnie Celsjusza na Fahrenheita, wpisz 1.\n");
printf("Jesli chcesz zamienic stopnie Fahrenheita na Celsjusza, wpisz 2.\n");
int w;
scanf("%d", &w);

float Tf;
float Tc;

switch(w)
{
case 1:
printf("Podaj temperature w skali Celsjusza\n");
scanf("%f", &Tc);
Tf = 32 + 1.8 * Tc;
printf("W skali Fahrenheita jest to %.2f stopni.\n", Tf);
break;

case 2:
printf("Podaj temperature w skali Fahrenheita.\n");
scanf("%f", &Tf);
Tc = (Tf - 32) * 5/9;
printf("W skali Celsjusza jest to %.2f stopni.\n", Tc);
break;

default:
printf("Brak takiego wyboru w menu.");
break;
}
return 0;
}
