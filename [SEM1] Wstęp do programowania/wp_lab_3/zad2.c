#include <stdio.h>
int main()
{
int tablica[6];
int i;
int max;
int min;
for(i=0; i<6; ++i){
	printf("Podaj liczbe nr: %d \n", i+1);
	scanf("%d", &tablica[i]);
}
min = tablica[0];
max = tablica[0];


for(i=1; i<6; ++i){
		if(tablica[i]<min){
			min = tablica[i];}		
		if(tablica[i]>max){
			max = tablica[i];}


}
printf("Najwieksza liczba to %d, a najmniejsza to %d.\n", max, min);
return 0;
}




