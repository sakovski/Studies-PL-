//Uzupelnij ponizszy program tak, aby po jego uruchomieniu na ekranie terminala
//wypisana zostala pozycja i dlugosc pierwszego dopasowania wyrazenia regularnego
//[pq][^a] + a w lancuchu s. Np. w przypadku gdy s = "aqr  b qabxx xryc pqr",
//to efektem dzialania programu powinno byc wyprowadzenie na erkan lancucha 1,8.

#include<stdio.h>

int main(void)
{
  char *s = "aqr  b qabxx xryc pqr";
  int x,y;
  asm volatile
  (
    ".intel_syntax noprefix;"
    "lea ebx, [%2];" // lea laduje adress
    "xor eax, eax;" //eax - tutaj wartosc z x - pozycja pierwszego dopasowania
    "xor ecx, ecx;" //ecx - tutaj wartosc z y - dlugosc pierwszego dopasowania

    "petla:"
    "mov al,[ebx];"   // pobierz litere
    "or al,al;"        // czy koniec slowa
    "jz wyjscie;"     // jezli zero idz do wyjscie
    "cmp al,'p';"    //   porownanie litery z 'p'
    "je HitPQ;"
    "cmp al,'q';"
    "je HitPQ;"
    "inc ebx;"   // przesuwa do nastepnej litery
    "inc eax;"   //zwieksza numer pozycji o 1
    "jmp petla;"

    "HitPQ:"
    "inc ecx;" //zwieksza dlugosc ciagu od p o 1
    "inc ebx;"  //przesuwa do nastepnej litery
    "mov al,[ebx];"
    "or al, al;"
    "jz wyjscie;"
    "cmp al, 'a';"
    "je HitA;"
    "jmp HitPQ;"

    "HitA:"

    "wyjscie:"
    "mov %0,eax;"
    "mov %1,ecx;"
    ".att_syntax prefix;"
    : "=r" (x), "=r" (y)
    : "r" (s)
    : "eax", "ebx", "ecx", "edx"
  );
  printf("%hd, %hd \n", x, y);
  return 0;
}
