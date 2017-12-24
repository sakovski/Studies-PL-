#Zad5:Program pobiera z linii zlecen x. Wypisuje najwiekszy poziom zaglebienia nawiasow
#wyrazenia x. Na 5pkt.

.intel_syntax noprefix
  .globl main
  .text

main:
pop eax
pop eax #argc
pop eax #argv
mov eax, [eax+4] #argv[1] czyli moj argument
sub esp, 12
lea ebx,[eax]	#argument x
xor eax,eax
xor ecx,ecx	#liczba najwiekszego zagniezdzenia
xor edx,edx     #przechowuje aktualne najwieksze zagniezdzenie


Petla:
  mov al,[ebx]	#wczytuje pojedynczy znak z argumentu x
  or al,al      #czy pusty
  jz print
  cmp al,'('
  je ZwiekszEcx
  cmp al,')'
  je ZmniejszEcx
  inc ebx	#przesuniecie o 1 znak w prawo
  jmp Petla

ZwiekszEcx:
inc ecx
cmp edx,ecx
js ZmienMax
inc ebx
jmp Petla

ZmienMax:
mov edx,ecx
inc ebx
jmp Petla

ZmniejszEcx:
dec ecx
inc ebx
jmp Petla

print:
push edx
mov edx, offset mesg
push edx
call printf
add esp,8
ret
mov edx,0
ret

.data
mesg: .asciz "Liczba zagniezdzonych nawiasow: %d\n"
