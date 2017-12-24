#include<stdio.h>
int trojkatProst(int, int, int);
int powRek(int, int, int);
int a, b, c;
int main(void)
{
  puts("podaj dlugosc boku a.");
  scanf("%d", &a);
  puts("Podaj dlugosc boku b.");
  scanf("%d", &b);
  puts("Podaj dlugosc boku c.");
  scanf("%d", &c);
  trojkatProst(a, b, c);
  return 0;
}

int trojkatProst(int a, int b, int c)
{
  if(a>=b && a>=c)
  {
    if(a*a == b*b + c*c)
      puts("Trojkat jest prostokatny");
    else
      puts("Trojkat nie jest prostokatny");
  }
  if(b>=a && b>=c)
  {
    if(b*b == a*a + c*c)
      puts("Trojkat jest prostokatny");
    else
      puts("Trojkat nie jest prostokatny");
  }
  if(c>=a && c>=b)
  {
    if(c*c == a*a + b*b)
      puts("Trojkat jest prostokatny");
    else
      puts("trojkat nie jest prostokatny");
  }
  return 1;
}
