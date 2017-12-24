#include <stdio.h>
int main()
{
int a, b;
printf("Wpisz dwie liczby calkowite\n");
scanf("%d %d", &a, &b);
printf("Jezeli chcesz dodac wcisnij 1\n");
printf("Jezeli chcesz odjac wcisnij 2\n");
printf("Jezeli chcesz pomnozyc wcisnij 3\n");
printf("Jezeli chcesz podzielic modulo wcisnij 4\n");

int x;
scanf("%d", &x);

int dodawanie = a + b;
int odejmowanie = a - b;
int mnozenie = a * b;
int modulo = a % b;

switch(x)
{
case 1:
printf("a+b=%d\n", dodawanie);
break;
case 2: 
printf("a-b=%d\n", odejmowanie);
break;
case 3:
printf("a*b=%d\n", mnozenie);
break;
case 4:("Reszta z dzielenia a mod b=%d", modulo);
break;
default:
printf("Blad");
break;
}
return 0;
}




