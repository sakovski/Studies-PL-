#include <stdio.h>

int main() {
  int x = -1;
  int x2= 0;

    // x*20
  asm volatile (
    ".intel_syntax noprefix;"
    "mov eax, %1;"
    "shl eax;"
    "jc zapalony;"
    "mov eax, 17;"
    "jmp koniec;"

    "zapalony:"
    "mov eax, 12;"
    "koniec:"
    "mov %0, eax;"


  //  "mov eax, %0;"
  //  "add eax, eax;" //*2
  //  "add eax, eax;" //*4
  //  "mov ebx, eax;"
  //  "add eax, ebx;" //*8
  //  "add eax, eax;" //*16
  //  "add eax, ebx;" //*20
  //  "mov %1, eax;"
    ".att_syntax prefix"

    : "=r" (x2)
    : "r" (x)
    : "eax", "ebx"
  );

  printf("x = %i, x2 = %i\n", x, x2);


  return 0;
}
