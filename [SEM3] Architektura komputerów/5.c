#include <stdio.h>

int main() {
  int x;
  printf("Podaj liczbe, a program wypisze najwiekszy ciag jedynek w zapisie binarnym liczby. \n");
  scanf("%d", &x);
  if (x==0)
  {
    printf("najdluzszy ciag = 0 \n");
    return 0;
  }
  int x2= 0;


  asm volatile (

    ".intel_syntax noprefix;" //
    "mov ecx, %1;"            // x1 do ecx
    "mov eax, 0;"             // zerowanie eax
    "xor ebx, ebx;"           // zerowanie ebx
    "petla:"
         "jecxz koniec;"      //jesli w ecx jest 0 idz do koniec
         "shl ecx;"           // przesuniecie bitowe w lewo
         "jc zwieksz;"        //jesli przesuniety bit = 1 idz do zwieksz
         "jnc wpiszdoeax;"    //jesli nie to idz do wpiszdoeax
    "zwieksz:"
         "inc ebx;"           //zwieksz ebx
         "jmp petla;"         //idz do petla
    "wpiszdoeax:"
         "cmp ebx, eax;"       // porownaj ebx z eax
         "jng zerowanie;"     //jesli ebx mniejsze idz do zerowanie
         "mov eax, ebx;"      //przypisz ebx do eax
    "zerowanie:"
         "mov ebx, 0;"        //przypisz 0 do ebx
         "jmp petla;"         //idz do petla
     "gdyzero:"
          "mov eax, ebx;"     //przypisz ebx do eax
          "jmp koniec;"       //idz do koniec
     "koniec:"
	 "cmp eax, 0;"              //czy eax = 0?
         "je gdyzero;"        //jeslirowne idz do gdyzero
         "mov %0, eax;"       //przypisz do x2 eax

    ".att_syntax prefix"

    : "=r" (x2)
    : "r" (x)
    : "eax", "ebx", "ecx"
  );

  printf("liczba = %i, najdluzszy ciag = %i\n", x, x2);

  return 0;
}
