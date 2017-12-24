;//Zad. 0.
;//Napisać program pobierający z linii zleceń dwa argumenty x i y tak, aby na ekranie terminala po jego uruchomieniu
;// wypisana została lista słów z łańcucha x, przy czym każde powtórzone y razy (słowa są to ciągi znaków alfanumerycznych
;// oddzielonych od siebie dowolną liczbą spacji). Np. w przypadku gdy x = ”aab xyz 3” i y = ”3”, to efektem działania
;// programu powinno być wyprowadzenie na ekran łańcucha:
;//aab aab aab xyz xyz xyz 3 3 3
.intel_syntax noprefix
	.text
	.globl _start

_start:
//Od tego momentu do komentarza program wypisanie na ekran jakie argumenty dostalismy (opcjonalne)
	mov edx, 0
	mov ebp, esp
  mov ecx, offset wejsciex
  mov edx, 0

  petla1:
  inc edx
  cmp byte ptr [ecx+edx-1], 0
  jnz petla1

  mov eax, 4
  mov ebx, 1
  int 0x80
	mov ecx, [ebp+8]
  mov edx, 0
petla2:
	inc edx
	cmp byte ptr [ecx+edx-1], 0
	jnz petla2

	mov eax, 4
	mov ebx, 1
	int 0x80

	mov eax, 4
	mov ebx, 1
	mov ecx, offset msg
	mov edx, 1
	int 0x80

  mov ecx, offset wejsciey
	mov edx, 0

	petla3:
	inc edx
	cmp byte ptr [ecx+edx-1], 0
	jnz petla3

	mov eax, 4
	mov ebx, 1
	int 0x80

	mov ecx, [ebp+12]
	mov edx, 0

	petla4:
	inc edx
	cmp byte ptr [ecx+edx-1], 0
	jnz petla4

	mov eax, 4
	mov ebx, 1
	int 0x80

	mov eax, 4
	mov ebx, 1
	mov ecx, offset msg
	mov edx, 1
	int 0x80
//Program

 mov ebx,[ebp+8];//Wczytujemy do ebx wskaźnik na początek łańcucha znaków (pierwszy prametr)
 mov ecx,0;//ecx wskazuje na ilość znaków w wyrazie
 mov al,[ebx];//Wczytujemy pierwszy znak
 licz1:;//Tutaj cofamy sie po wypisaniu y razy wyrazu
cmp al,0;//Jeżeli doszliśmy do końca napisu to kończymy
jz koniec
 add ebx,ecx;//Ustawiamy ebx na początek następnego niewypisanego wyrazu
 mov ecx ,0;//Zerujemy długość wyrazu
 licz:;//Tutaj cofamy się jeżeli nie znaleźliśmy końca wyrazu ani końca napisu
mov al,[ebx+ecx];//Wczytujemy następny znak
 inc ecx;//Zwiekszamy licznik znaków w wyrazie
 cmp al,' ';//Jeżeli znaleźliśmy spacje to kończymy zliczanie znaków
 jz spacja
 cmp al,0;//Jeżeli doszliśmy do końca napisu to kończymy zliczanie ale nie kończymy programu(wypiszemy ostatni wyraz)
 jz spacja
  jmp licz;//Jeżeli nie znaleźliśmy końca ani spacji to zliczamy dalej znaki
 spacja:
push eax
push ebx
push ecx
mov edx,0 ;//Czytanie parametru y
mov ecx, [ebp+12] ;//Zamisujemy wskaźnik na y
czytaj:
	mov bl, byte ptr [ecx] ;//Zapisujemy znak jako liczbe (ASCII)
	sub bl, '0' ;//Odejmujemy kod ASCII zera(kod ASCII cyfry minus kod zera to ta cyfra)
	movzx ebx, bl ;//Wpisujemy cyfre do ebx
	add edx, ebx;//Zapisujemy wynik w edx
	inc ecx;//Przesuwamy wskaźnik na następny znak
	mov bl, [ecx];//Czytamy znak
	cmp bl,0;//Jeżeli doszliśmy do końca to mamy wynik
	jz liczba
	imul edx,10;//Jeżeli liczba ma więcej znaków to mnożymy razy 10 żeby dodać nowy znak
	jmp czytaj
liczba:

pop ecx
pop ebx
pop eax

 cmp edx,0;//Jeżeli mamy wypisać każdy wyraz 0 razy to koniec
 jz koniec
 druk:
 cmp edx,0;//W edx przechowujemy ile razy mamy wypisać dany wyraz
 jz licz1;//Jeżeli wypisaliśmy go y razy to wracamy do czytania następnego wyrazu
 push eax
 push ebx
 push ecx
 push edx
 mov eax, 4
 mov edx, ecx;//W edx mamy ile znaków wypisać
 mov ecx, ebx;//W ecx mamy adres łańcucha który wypisujemy
 mov ebx, 1
 int 0x80
 pop edx
 pop ecx
 pop ebx
 pop eax
 dec edx;//Wypisaliśmy wyraz więc zmniejszamy liczbę wyrazów do wypisania o 1
 cmp al,0;//Jeżeli wypisujemy ostatni wyraz to po nim nie ma spacji więc musimy ja dodać
 jnz ostatni
push eax
push ebx
push ecx
push edx
mov eax,4
mov ebx,1
mov ecx,offset pusty
mov edx,1
int 0x80
pop edx
pop ecx
pop ebx
pop eax
ostatni:
 jmp druk;//Wracamy do druk żeby zdecydować czy wypisujemy wyraz jeszcze raz czy szukamy następnego

 koniec:
mov eax,4
mov ebx,1
mov ecx,offset msg
mov edx,1
int 0x80;//Wypisanie konća lini (bo lubie :) )

	mov eax, 1
	mov ebx, 0
	int 0x80;//RETURN 0;

	.data
msg:	.ascii "\n"
wejsciex: .asciz "Dostałem x:= "
wejsciey: .asciz "Dostałem y:= "
pusty: .asciz " "
