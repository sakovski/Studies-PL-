
#include <stdio.h>
int main()
{
int t;
printf("Podaj ile ma byc zestawow danych.\n");
scanf("%d", &t);
int v1, v2, i;
float v[t];
for(i=0; i<t; i++)
{
	printf("Podaj v1 i v2 oddzielone spacja.\n");
	scanf("%d %d", &v1 , &v2);
	v[i] = (2 * v1 * v2) / (v1 + v2);
}
for(i=0; i<t; i++)
{ 
 
  printf("%.2f\n", v[i]);

}
return 0;
}
