#include<stdio.h>

int main(void)
{

  int n, wynik;
  asm volatile
  (
    ".intel_syntax noprefix;"
    "mov %1, eax;"
    "cmp eax, 2;"
    ""
    "mov %0, edx;"

    ".att_syntax prefix;"
    : "=r" (wynik)
    : "r" (n)
    : "eax", "ebx", "ecx", "edx"
  );

  return 0;
}
