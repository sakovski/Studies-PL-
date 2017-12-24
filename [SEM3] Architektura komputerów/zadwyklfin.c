//Uzupelnij ponizszy program tak, aby po jego uruchomieniu na ekranie terminala
//wypisana zostala pozycja i dlugosc pierwszego dopasowania wyrazenia regularnego
//[pq][^a] + a w lancuchu s. Np. w przypadku gdy s = "aqr  b qabxx xryc pqr",
//to efektem dzialania programu powinno byc wyprowadzenie na erkan lancucha 1,8.

#include<stdio.h>

int main(void)
{
  char *s = "";
  int x,y;
  asm volatile
  (
    ".intel_syntax noprefix;"
    "lea ebx, [%2];" // lea laduje adres
    "xor edx, edx;" //edx - tutaj wartosc z x - pozycja pierwszego dopasowania
    "xor ecx, ecx;" //ecx - tutaj wartosc z y - dlugosc pierwszego dopasowania
    "inc ecx;"      //zwiekszam ecx do 1

    "petla:"
    "mov al,[ebx];"   // pobierz litere
    "or al,al;"        // czy koniec slowa
    "jz niemaa;"     // jezli zero idz do niemaa
    "cmp al, 'p';"    //   porownanie litery z 'p'
    "je czyapopq;"      //jesli p idz do czyapopq
    "cmp al, 'q';"    //porownanie litery z 'q'
    "je czyapopq;"      //jesli q idz do czyapopq
    "inc ebx;"   // przesuwa do nastepnej litery
    "inc edx;"   //zwieksza numer pozycji o 1
    "jmp petla;"

    "popqa:"
    "mov ecx, 1;"
    "inc ebx;"  //przesuwa do nastepnej litery
    "inc edx;"  //zwieksza numer pozycji o 1
    "jmp petla;"

    "czyapopq:"
    "inc ebx;"   //przesuwa do nastepnej litery
    "inc ecx;"    //zwieksza dlugosc ciagu o 1
    "mov al, [ebx];" //pobiera litere
    "or al, al;"    //czy koniec slowa
    "jz niemaa;"   //jesli koniec idz do niemaa
    "cmp al, 'a';"  //czy po p lub q jest a
    "je popqa;"     //jesli tak, wroc do petli

    "HitPQ:"
    "inc ebx;"  //przesuwa do nastepnej litery
    "inc ecx;" //zwieksza dlugosc ciagu od p o 1
    "mov al,[ebx];"  //pobiera litere
    "or al, al;"    //czy koniec slowa
    "jz niemaa;"   //jesli koniec idz do niemaa
    "cmp al, 'a';"  //porownuje litere z 'a'
    "je wyjscie;"      //jesli a idz do wyjscie
    "jmp HitPQ;"    //idz do HitPQ

    "niemaa:"  //jesli nie ma a po p lub q, przypisuje 0 do obu zmiennych
    "mov %0, 0;"
    "mov %1, 0;"
    "jmp koniec;"

    "wyjscie:"
    "mov %0,edx;"
    "mov %1,ecx;"

    "koniec:"

    ".att_syntax prefix;"
    : "=r" (x), "=r" (y)
    : "r" (s)
    : "eax", "ebx", "ecx", "edx"
  );
  printf("Pozycja pierwszego dopasowania - %hd, Dlugosc ciagu - %hd \n", x, y);
  return 0;
}
