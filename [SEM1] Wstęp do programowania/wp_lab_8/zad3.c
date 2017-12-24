//struktury

#include <stdio.h>

 struct osoba
{
  char imie[99];
  char nazwisko [99];
  int wiek;
  float srednia;
} uczen;    //wywolanie instancji

int main(void)
{
 
  printf("Podaj imie: ");
  scanf("%99s", uczen.imie);
  printf("\n");
  printf("Podaj nazwisko: ");
  scanf("%99s", uczen.nazwisko);
  printf("\n");
  printf("Podaj wiek: ");
  scanf("%d", &uczen.wiek);
  printf("\n");
  printf("Podaj srednia ocen: ");
  scanf("%f", &uczen.srednia);

  printf("IMIE: %s \n", uczen.imie);
  printf("NAZWISKO: %s \n", uczen.nazwisko);
  printf("WIEK: %d \n", uczen.wiek);
  printf("SREDNIA: %.2f \n", uczen.srednia);

  return 0;
}
