#include <stdio.h>
int main()
{
int n;
printf("Podaj liczbe naturalna z zakresu od 1 do 30\n");
scanf("%d", &n);
int i;
long int silnia = 1;
	for(i = n; i > 0; --i)
			silnia = silnia * i;
	printf("Silnia z liczby %d wynosi %ld\n", n, silnia);
return 0;
}


