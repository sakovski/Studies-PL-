//       {1                              dla n=0
//f(n)=  {0                              dla n=1
//       {3                              dla n=2
//       {f(n-1)-f(n-2)+f(n-3)*2   w pozostałych przypadkach
//Pierwszy argument przekazywany przez rejestr EBX, pozostałe argumenty przekazywane przez stos.
//Wynik zwracany przez rejestr EDX.
//Za uporządkowanie stosu odpowiada wywołujący funkcję.
//Wywoływana funkcja musi zachować wszystkie rejesty(oprócz rejestru, w którym zwracany jest wynik).
//Sprowac wywolas ja przez wartosc a nie przez stos - push ebx jest zle
//tutaj wywolalem przez rejestr a nie przez stos, tak jak powinno byc

.intel_syntax noprefix

	.globl main
	.text

main:
	mov ebx,4    	 #przypisz zmienna n
	xor ecx,ecx
	//wywołanie funkcji
	call f            	#wywołanie funkcji f
  push edx        #wypisz wynik
	push offset msg
	call printf
	add esp,8
	ret
  mov ebx,0
	ret

f:
	mov edx,0
	push ebp #zapamietanie rejestow na stosie
	mov ebp, esp	   #zapamietanie miejsca stosu
  push ebx
	push ecx

	//poszczegolne przypadki dla n=0,1,2,reszta
	cmp ebx,0   #n0
	jne n1
	mov edx,1
	jmp koniec

	n1:					#n1
  cmp ebx,1
	jne n2
	mov edx,0
	jmp koniec

	n2:						#n2
  cmp ebx,2
	jne n3
	mov edx,3
	jmp koniec

	n3:						#reszta
	//f(n-1)
	push ebx #zapamietanie n
	sub ebx,1 #ebx na n-1
	push edx #zapamietanie wyniku
	push ebx #parametr n-1 dla funkcji
	call f
	add esp, 4   #czyszczenie stosu
	pop ecx				#do ecx wynik f(n-1)
	add edx,ecx			#do wyniku dodajemy f(n-1)
	pop ebx				#przywaracamy pocztakowe n

	//-f(n-2)
	push ebx
	sub ebx,2
	push edx
	push ebx
	call f
	add esp, 4
	pop ecx
	sub ecx,edx         #(odejmuje f(n-2) od reszty) i zapisuje w ecx
	mov edx, ecx        #przypisuje ecx w ktorym jest wynik do edx, bo musi byc
	pop ebx							#przywrocenie n

	//f(n-3)*2
	push ebx
	sub ebx,3
	push edx

	push ebx
	call f
	add esp, 4

	pop ecx
	add edx, edx  		#mnozy f(n-3)*2
	add edx,ecx
	pop ebx

koniec:
	//przywracanie rejestrów
	pop ecx
	pop ebx
	pop ebp
	ret

	.data
	msg:	.asciz "Wynik koncowy = %d\n"
	.byte 0
