#include<stdio.h>
int main(void)
{
int x1=sizeof(short int);
int x2=sizeof(long int);
int x3=sizeof(char);
int x4=sizeof(float);
int x5=sizeof(double);
int x6=sizeof(long double);
printf("Typ zmiennej short int zajmuje w pamieci %d\n",x1); 
printf("Typ zmiennej long int zajmuje w pamieci %d\n",x2); 
printf("Typ zmiennej char zajmuje w pamieci %d\n",x3); 
printf("Typ zmiennej float int zajmuje w pamieci %d\n",x4); 
printf("Typ zmiennej double zajmuje w pamieci %d\n",x5); 
printf("Typ zmiennej long double zajmuje w pamieci %d\n",x6);


return 0;
}
