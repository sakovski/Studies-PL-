//zad 3.4

#include<stdio.h>
#include<stdlib.h>
#include<math.h>

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
  if(p<r)
  {
    q=Partition(A,p,r);
    Quicksort(A,p,q);
    Quicksort(A,q+1,r);
  }
}
int main(void)
{
  int i;
  int A[6] = {3,0,14,16,18,7};
  Quicksort(A, 0, 5);

  for(i=0;i<6;i++)
  {
    printf("%d \n", A[i]);
  }
  return 0;
}
