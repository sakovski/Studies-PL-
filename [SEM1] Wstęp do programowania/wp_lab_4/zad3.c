#include <stdio.h>
int main()
{
int d;
printf("Podaj liczbe przypadkow testowych.\n");
scanf("%d", &d);
int a, b, i;
int r[d];
for(i=0; i<d; i++){
	printf("Podaj liczby a i b oddzielone spacjami.\n");
	scanf("%d %d", &a, &b);
	r[i] = a % b;
	}
for(i=0; i<d; i++){
	printf("Reszty z dzielenia wynosza %d\n", r[i]);
	}
return 0;
} 
