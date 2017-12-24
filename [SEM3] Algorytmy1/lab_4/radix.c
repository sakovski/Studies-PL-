#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define MAXSIZE 256


void print(char **A, int n, int j)
{
  int i;
  printf("\nPosortowane do pozycji: %d\n", j);

  for(i=0; i<n; i++)
  {
    printf("%c | %s\n", *(A[i]+j),A[i]);
  }
}

int CzytajNapisy(char **A, int ilosc)
{
  char string[MAXSIZE];
  int h, dlugosc, max = 0;
  for(h=0; h<ilosc; h++)
  {
    scanf("%s", string);
    dlugosc = strlen(string);
    if(dlugosc>max)
    {
        max = dlugosc;
    }
    A[h] = (char*) malloc(sizeof(char) * MAXSIZE);
    strcpy(A[h], string);
  }
  return max;
}

void countingSort(char **A, char **B, int LiczbaSlow, int currentLetter)
{
  int C[MAXSIZE];
  int i, j;

  for(i=0; i<MAXSIZE; i++) //zerowanie
  {
    C[i] = 0;
  }
  for(j=0; j<LiczbaSlow; j++)
  {
    //zmiana na male litery
    if((A[j][currentLetter] >= 65) && (A[j][currentLetter]<=90))
    {
      A[j][currentLetter] += 32;
    }
    

    C[A[j][currentLetter]]++;
  }
  for(i=1; i<MAXSIZE; i++)
  {
      C[i] += C[i-1];
  }

  for(j = LiczbaSlow - 1; j >= 0; j--)
  {

    B[C[A[j][currentLetter]]-1] = A[j];
    C[A[j][currentLetter]]--;
  }
}

void radixSort(char **A, int LiczbaSlow, int largest)
{
  int i, j;
  char *B[LiczbaSlow];

  for(i = largest - 1; i>=0; i--) // pętla idzie od ostaniej litery
  {
    countingSort(A, B, LiczbaSlow, i); // sortowanie ostatniej litery

    for(j = 0; j<LiczbaSlow; j++) // przypisanie posortowanych liter w pętli
    {
        A[j] = B[j];
    }
    print(A, LiczbaSlow, i); // Wypisanie aktualnie sortowanych liter
  }
}

int main (void)
{
  int i, ileslow, dlugosc;
  printf("Ilosc slow do wczytania: ");
  scanf("%d", &ileslow);
  char **A = (char**) malloc(ileslow * sizeof(char*));
  printf("Podaj te wyrazy: ");
  dlugosc = CzytajNapisy(A, ileslow);
  radixSort(A, ileslow, dlugosc);
  for(i=0; i<ileslow; i++)
  {
      printf("%s\n", A[i]);
  }

  return 0;
}
