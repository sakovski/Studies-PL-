#include <stdio.h>

int main() {
  int x = -1;
  int x2= 0;

    //iel razy wystepuja w jedynki po sobie
    // przesuwac w lewo i porownywac 2 ostatnie
  asm volatile (
    ".intel_syntax noprefix;"
    "mov ecx, eax;"
    "and ecx, 0xC0000000;"
    "start:"
    "cmp ecx, 0xC0000000;"

    ".att_syntax prefix"

    : "=r" (x2)
    : "r" (x)
    : "eax", "ebx", "ecx"
  );

  printf("x = %i, x2 = %i\n", x, x2);


  return 0;
}
