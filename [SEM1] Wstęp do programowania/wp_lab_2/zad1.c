#include <stdio.h>
int main(void)
{
float Tc;
printf("Podaj stopnie w skali Celcjusza\n");
scanf("%f", &Tc);
float Tf = 32 + 9 / 5 * Tc;
printf("Temperatura w skali Fahrenheita wynosi %.2f\n", Tf);
return 0;
}

