#include <stdio.h>
#include <stdlib.h>
#include <time.h>
int main()
{
printf("Wylosowalem liczbe z zakresu od 0-9. Zgadnij jaka to liczba.\n");
int liczba_uzytkownika;
scanf("%d", &liczba_uzytkownika);
srand ( time ( NULL ) );
int liczba_programu = rand() % 10;

if( liczba_uzytkownika == liczba_programu)
printf("BRAWO! Zgadles liczbe. To byla liczba %d.\n", liczba_programu);
else
printf("Niestety nie zgadles liczby. To byla lizba %d.\n", liczba_programu);

return 0;
}

