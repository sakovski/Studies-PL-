#include <stdio.h>
int main()
{
int a, b;
printf("Wpisz dwie liczby calkowite oddzielone spacja");
scanf("%d %d", &a, &b);
int dodawanie = a + b;
int odejmowanie = a - b;
int mnozenie = a * b;
int dzielenie = a / b;
int modulo = a % b;
printf("Wynik dodawania tych liczb: %d\n", dodawanie);
printf("Wynik odejmowania tych liczb: %d\n", odejmowanie);
printf("Wynik mnozenia tych liczb: %d\n", mnozenie);
printf("Wynik dzielenia tych liczb: %d\t", dzielenie);
printf("Reszta z dzielenia: %d\n", modulo);
return 0;
}
