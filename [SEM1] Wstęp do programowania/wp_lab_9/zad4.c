#include <stdio.h>

int main(void)
{
  FILE *plik1=fopen("odczyty.txt","r");
  FILE *plik2=fopen("rezystancja.txt","w");
  float R;
  float U[10];
  float I[10];
  int i;
  for(i=0;i<20;i=i+2)
  {
  fscanf(plik1,"%f",&U[i]);
  fscanf(plik1,"%f",&I[i+1]);
  R=U[i]/I[i+1];
  fprintf(plik2,"%.2f\n",R);
  }
  fclose(plik1);
  fclose(plik2);
  return 0;
}
