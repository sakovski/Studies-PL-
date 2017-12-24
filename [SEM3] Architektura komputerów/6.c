#include <stdio.h>

int main() {
  int x;
  printf("Podaj ciag znakow, a program wypisze najdluzszy ciag w zapisie binarnym liczby. \n");
  scanf("%d", &x);
  int x2= 0;
  asm volatile (




    ".att_syntax prefix"

    : "=r" (x2)
    : "r" (x)
    : "eax", "ebx", "ecx"
  );

  printf("x = %i, x2 = %i\n", x, x2);

  return 0;
}
