#include <stdio.h>
int main()
{
int tablica[10];
int dodawanie = 0;
int i;
for(i=0; i<=9; ++i){
	printf("Podaj liczbe nr %d \n", i+1);
	scanf("%d", &tablica[i]);
	dodawanie = dodawanie + tablica[i];
	}	

printf("Wynik dodawania tych liczb wynosi: %d.\n", dodawanie);




return 0;
}

