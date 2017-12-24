#include <stdio.h>

int main() {
  int x = -1;
  int x2= 0;

    // x*20
  asm volatile (
    ".intel_syntax noprefix;"
    "mov eax, %1;"
    "mov ebx, 0;"  //xor ebx, ebx;
    "shl eax;"
    "jnc a1;"
    "add ebx, 1;"   //inc ebx;
    "a1:"
          "shl eax;"
          "jnc a2;"
          "add ebx, 1;"   //inc ebx;
    "a2:"
            "mov %0, ebx;"

    ".att_syntax prefix"

    : "=r" (x2)
    : "r" (x)
    : "eax", "ebx"
  );

  printf("x = %i, x2 = %i\n", x, x2);


  return 0;
}
