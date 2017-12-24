#include<stdio.h>

int main(void)
{
  float a;
  int n;
  float p;
  puts("Podaj dlugosc boku kafelka w metrach");
  scanf("%f", &a);
  if(a<0)
  {
    puts("Dlugosc boku musi byc wieksza od 0");
    return 0;
  }
  puts("Podaj liczbe kafelkow");
  scanf("%d", &n);
  if(n<0)
  {
    puts("Liczba kafelkow  musi byc wieksza od 0");
    return 0;
  }

  puts("Podaj powierzchnie sciany w metrach kwadratowych");
  scanf("%f", &p);
  if(p<0)
  {
    puts("Powierzchnia sciany musi byc wieksza od 0");
    return 0;
  }
  if(n*a*a==p)
    printf("Powierzchnia %d kafelkow o boku %.2f jest rowna powierzchni %.2f", n, a, p);
  else
     printf("Powierzchnia %d kafelkow o boku %.2f nie jest rowna powierzchni %.2f\n", n, a, p);
  return 0;
}  

