#include<stdio.h>
#include<stdlib.h>
#include<math.h>

struct prostokat
{
  int a;
  int b;
  int x;
  int y;
} figura;

int main(void)
{
  puts("Podaj wspolrzedna x punktu A");
  scanf("%d", &figura.a);
  puts("Podaj wspolrzedna y punktu A");
  scanf("%d", &figura.b);
  puts("Podaj wspolrzedna x puntu B");
  scanf("%d", &figura.x);
  puts("Podaj wspolrzedna y punktu B");
  scanf("%d", &figura.y);
  float d;
  d=sqrt(((figura.x-figura.a)*(figura.x-figura.a))+((figura.y-figura.b)*(figura.y-figura.b)));
  if(d<=0)
    puts("BLAD! Ta figura nie moze byc prostokatem!!!");
  else
    printf("Przekatna tego prostokata ma dlugosc %f \n", d);
  return 0;
}
