#include <stdio.h>

int main() {
  int x;
  printf("Podaj liczbe, a program wypisze liczbe jedynek w zapisie binarnym liczby. \n");
  scanf("%d", &x);
  int x2= 0;

    //iel razy wystepuja w jedynki po sobie
    // przesuwac w lewo i porownywac 2 ostatnie
  asm volatile (
    ".intel_syntax noprefix;"
    "mov ecx, %1;"
    "mov eax, 0;"
    "xor ebx, ebx;"
    "petla:"
         "jecxz koniec;"
         "shl ecx;"
         "jc zwieksz;"
         "jnc wpiszdoeax;"
         "jnc petla;"
    "zwieksz:"
         "inc ebx;" 
         "jmp petla;"
    "wpiszdoeax:"
         "cmp eax, 0;"
         "jne sprawdz;"
         "mov eax, ecx;"
         "xor ecx, ecx;"
         "jmp petla;"
    "sprawdz:"
         "cmp eax, ecx;"
         "jb wpiszdoeax;" 
    "koniec:"
         "mov %0, ebx;"

    ".att_syntax prefix"

    : "=r" (x2)
    : "r" (x)
    : "eax", "ebx", "ecx"
  );

  printf("x = %i, x2 = %i\n", x, x2);


  return 0;
}

