#include <stdio.h>
int a, b;
int dodawanie(int a, int b);
int odejmowanie(int a, int b);
int mnozenie(int a, int b);
int dzielenie(int a, int b);

int main(void)
{
puts("Podaj 2 liczby calkowite oddzielone spacja.");
scanf("%d %d", &a, &b);
printf("Wynik dodawania tych liczb to: %d\n", dodawanie(a, b));
printf("Wynik odejmowania tych liczb to: %d\n", odejmowanie(a, b));
printf("Wynik mnozenia tych liczb to: %d\n", mnozenie(a, b));
printf("Wynik dzielenia tych liczb to: %d\n", dzielenie(a, b));


return 0;
}
int dodawanie(int a, int b)
{
return a+b;
}
int odejmowanie(int a, int b)
{
return a-b;
}
int mnozenie(int a, int b)
{
return a*b;
}
int dzielenie(int a, int b)
{
return a/b;
}
