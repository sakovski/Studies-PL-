//c.d. struktur

#include <stdio.h>

typedef struct
{
  char imie[99];
  char nazwisko [99];
  int wiek;
  float srednia;
} uczen;    //wywolanie instancji

int main(void)
{
  FILE *fp;
  fp=fopen("a.txt", "a");
  puts("Podaj ilu uczniow chcesz dodac:");
  int n;
  scanf("%d", &n);
  uczen osoba[n];
  int i;
  for(i=0;i<n;i++)
  {
    printf("Podaj imie: ");
    scanf("%99s", osoba[i].imie);
    fprintf(fp, "\n%s", osoba[i].imie);
    printf("\n");

    printf("Podaj nazwisko: ");
    scanf("%99s", osoba[i].nazwisko);
    fprintf(fp, "\n%s", osoba[i].nazwisko);
    printf("\n");

    printf("Podaj wiek: ");
    scanf("%d", &osoba[i].wiek);
    fprintf(fp, "\n%d", osoba[i].wiek);
    printf("\n");

    printf("Podaj srednia ocen: ");
    scanf("%f", &osoba[i].srednia);
    fprintf(fp, "\n%f", osoba[i].srednia);
  }
  return 0;
}


