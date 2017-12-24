#include <stdio.h>
int main()
{
int z; //ilosc zestawow testowych
printf("Podaj ile ma byc zestawow testowych.\n");
scanf("%d", &z);
int N, M; //ilosc obzartuchow, ilosc ciastek w pudelku
int lp = 0; //liczba pudelek
int tab[z];
int i, j, k;
for(j=0; j<z; j++){
	printf("Podaj liczbe zaproszonych obzartuchow i liczbe ciastek w 1 pudelku. Oddziel te wartosci spacja.\n");
	scanf("%d %d", &N, &M);
        for(i=0; i<N; i++){
		int tab1[N];
		printf("Podaj czas w sekundach jedzenia pojedynczego ciastka przez obzartucha nr %d\n", i+1);
		scanf("%d", &tab1[i]);
		lp = lp , (86400/tab1[i]) / M;
			  }
	tab[j] = lp;
		 }
printf("Liczba pudelek potrzebna dla zestawu:\n");
for(k=1; k<=z; k++){
	printf("nr %d: %d\n", k, tab[j]);
		   }
return 0;
}


