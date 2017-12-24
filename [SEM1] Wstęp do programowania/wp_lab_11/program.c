#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include "obwody.h"
#include "pola1.h"
#include "pola2.h"
#include "objetosci.h"
>
int main(void)
{
  int x, y, z;
  puts("Obliczanie pol  i objetosci wybranych figur geometrycznych");
  puts("MENU GLOWNE:");
  puts("(Aby przejsc do danej sekcji wpisz dany numer i zatwierdz enterem)");
  puts("1 Obwody figur plaskich");
  puts("2 Pola figur plaskich");
  puts("3 Pola figur przestrzennych");
  puts("4 Objetosci figur przestrzennych");
  scanf("%d", &x);
  switch(x)
  {
    case 1:
      system("clear");
      puts("1.1 Obwod kwadratu");
      puts("1.2 Obwod prostokata");
      puts("1.3 Obwod trojkata");
      puts("1.4 Obwod kola");
      puts("1.5 Obwod trapezu");
      puts("1.6 Obwod rombu");
      puts("1.7 Obwod rownolegloboku");
      scanf("%d", &y);
      switch(y)
      {
        case 1:
          Obwkwa();
          break;
        case 2:
          Obwpro();
          break;
        case 3:
          Obwtro();
          break;
        case 4:
          Obwkol();
          break;
        case 5:
          Obwtra();
          break;
        case 6:
          Obwrom();
          break;
        case 7:
          Obwrow();
          break;
      }
      break;
    case 2:
      system("clear");
      puts("2.1 Pole kwadratu");
      puts("2.2 Pole prostokata");
      puts("2.3 Pole trojkata");
      puts("2.4 Pole kola");
      puts("2.5 Pole trapezu");
      puts("2.6 Pole rombu");
      puts("2.7 Pole rownolegloboku");
      scanf("%d", &y);
      switch(y)
      {
        case 1: 
          Polkwa();
          break;
        case 2:
          Polpro();
          break;
        case 3:
          Poltro();
          break;
        case 4:
          Polkol();
          break;
        case 5:
          Poltra();
          break;
        case 6:
          Polrom();
          break;
        case 7:
          Polrow();
          break;
      }
      break;
    case 3:
      system("clear");
      puts("3.1 Pola graniastoslupow");
      puts("3.2 Pola ostroslupow");
      puts("3.3 Pola figur obrotowych");
      scanf("%d", &y);
      switch(y)
      {
        case 1:
          system("clear");
          puts("3.1.1 Pole graniastoslupa prawidlowego czworokatnego");
          puts("3.1.2 Pole graniastoslupa prawidlowego trojkatnego");
          puts("3.1.3 Pole graniastoslupa prawidlowego szesciokatnego");
          scanf("%d", &z);
          switch(z)
          {
            case 1:
              Polgraczw();
              break;
            case 2:
              Polgratro();
              break;
            case 3:
              Polgrasze();
              break;
          }
          break;
        case 2:
          system("clear");
          puts("3.2.1 Pole ostroslupa prawidlowego czworokatnego");
          puts("3.2.2 Pole ostroslupa prawidlowego trojkatnego");
          puts("3.2.3 Pole ostroslupa prawidlowego szesciokatnego");
          scanf("%d", &z);
          switch(z)
          {
            case 1:
              Polostczw();
              break;
            case 2:
              Polosttro();
              break;
            case 3:
              Polostsze();
              break;
           }
           break;
        case 3:
          system("clear");
          puts("3.3.1 Pole walca");
          puts("3.3.2 Pole stozka");
          puts("3.3.3 Pole kuli");
          scanf("%d", &z);
          switch(z)
          {
            case 1:
              Polwal();
              break;
            case 2:
              Polsto();
              break;
            case 3:
              Polkul();
              break;
           }
           break;
      }
        break;
    case 4:
      system("clear");
      puts("4.1 Objetosc graniastoslupow");
      puts("4.2 Objetosc ostroslupow");
      puts("4.3 Objetosc figur obrotowych");
      scanf("%d", &y);
      switch(y)
      {
        case 1:
          system("clear");
          puts("4.1.1 Objetosc graniastoslupa prawidlowego czworokatnego");
          puts("4.1.2 Objetosc graniastoslupa prawidlowego trojkatnego");
          puts("4.1.3 Objetosc graniastoslupa prawidlowego szesciokatnego");
          scanf("%d", &z);
          switch(z)
          {
            case 1:
              Objgraczw();
              break;
            case 2:
              Objgratro();
              break;
            case 3:
              Objgrasze();
              break;
          }
          break;
        case 2:
          system("clear");
          puts("4.2.1 Objetosc ostroslupa prawidlowego czworokatnego");
          puts("4.2.2 Objetosc ostroslupa prawidlowego trojkatnego");
          puts("4.2.3 Objetosc ostroslupa prawidlowego szesciokatnego");
          scanf("%d", &z);
          switch(z)
          {
            case 1:
              Objostczw();
              break;
            case 2:
              Objosttro();
              break;
            case 3:
              Objostsze();
              break;
          }
          break;
        case 3:
          system("clear");
          puts("4.3.1 Objetosc walca");
          puts("4.3.2 Objetosc stozka");
          puts("4.3.3 Objetosc kuli");
          scanf("%d", &z);
          switch(z)
          {
            case 1:
              Objwal();
              break;
            case 2:
              Objsto();
              break;
            case 3:
              Objkul();
              break;
          }
          break;
      }
      break;
  }
  return 0;
}


