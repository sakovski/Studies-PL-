#include<stdio.h>
#include<stdlib.h>
#include<math.h>

#define NUMBER 3

void swap(int A[], int x, int y)
{
  int temp;
  temp = A[x];
  A[x] = A[y];
  A[y] = temp;
}

int Partition(int A[], int p, int r)
{
  int x=A[r];    //element wyznaczajacy podzial
  int i=p-1;
  int j;
  for(j=p; j<=r; j++)
  {
    if(A[j]<=x)
    {
      i=i+1;
      swap(A, i, j);
    }
  }
  if(i<r)
    return i;
  else
    return i-1;
}
void Quicksort(int A[], int p, int r)
{
  int q;

  if(r-p+1>NUMBER)
  {
      q=Partition(A,p,r);
      Quicksort(A,p,q);
      Quicksort(A,q+1,r);
  }
}

void Insertionsort(int tab[], int size)
{
    int temp, j, i;
    for(i=1; i<size; ++i)
    {
      temp = tab[i];
      for(j=i-1; j>=0 && tab[j] > temp; --j)
             tab[j+1] = tab[j];

      tab[j+1] = temp;
    }
}

int main(void)
{
  int i, j;
  int ile_elementow;
  printf("Ile elementow tablicy chcesz podac? \n");
  scanf("%d", &ile_elementow);
  int A[ile_elementow];
  for(j=1;j<ile_elementow+1;j++)
  {
    printf("Podaj element %d \n", j);
    scanf("%d", &A[j-1]);
  }

    Quicksort(A, 0, ile_elementow);
    //Insertionsort(A, ile_elementow);



  for(i=0;i<ile_elementow;i++)
  {
    printf("%d \n", A[i]);
  }

  return 0;
}
