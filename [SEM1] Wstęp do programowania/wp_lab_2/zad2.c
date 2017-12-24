#include <stdio.h>
#include <math.h>
int main()
{
int a, b, c;
printf("Podaj wspolczynniki a, b i c wielomianu kwadratowego\n");
scanf("%d %d %d", &a, &b, &c);

float d = pow(b, 2) - 4 * a * c;

if(d > 0){
float d1 = sqrt(d);
float x1 = (-b - d1) / 2 * a;
float x2 = (-b + d1) / 2 * a;
	printf("x1= %6.2f, a x2= %6.2f\n", x1, x2);}
if(d == 0){
float x1 = -b / 2 * a;
	printf("x1= %6.2f\n", x1);}
if(d < 0){
	printf("Rownanie sprzeczne\n");}
return 0;
}
