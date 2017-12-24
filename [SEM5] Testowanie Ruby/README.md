# Testowanie aplikacji Ruby - Laboratorium 2017/2018
### Prowadzący: [Włodzimierz Bzyl](https://github.com/wbzyl)
### Student: [Seweryn Rutkowski](https://github.com/sakovski) _srutkowski@sigma.ug.edu.pl_

*****
## Travis CI
[![Build Status](https://travis-ci.org/my-rspec/hello-rspec-sakovski.svg?branch=master)](https://travis-ci.org/my-rspec/hello-rspec-sakovski)
## Zadania
* **[CodeQuizzes](https://github.com/my-rspec/hello-rspec-sakovski/tree/master/CodeQuizzes)**
  [_Link do strony_](http://www.codequizzes.com/)
  >[lib](CodeQuizzes/lib)  
  >[spec](CodeQuizzes/spec)
* **[Exercism](https://github.com/my-rspec/hello-rspec-sakovski/tree/master/MiniTest)**
   [_Link do strony_](http://exercism.io/)
   >[lib](MiniTest/lib)  
   >[spec](MiniTest/spec)

## Projekt 21.11.2017
* **[CountingSort](https://github.com/my-rspec/hello-rspec-sakovski/tree/master/ProjectCountingSort)**
   >[lib](ProjectCountingSort/lib)  
   >[spec](ProjectCountingSort/spec)

##### Sortowanie przez zliczanie (ang. counting sort) – metoda sortowania danych, która polega na sprawdzeniu ile wystąpień kluczy mniejszych od danego występuje w sortowanej tablicy.
###### Zalety
 Główną zaletą tej metody jest liniowa złożoność obliczeniowa algorytmu – O(n+k)[2] (n – oznacza liczebność zbioru, k – rozpiętość danych, czyli w przypadku liczb całkowitych: powiększoną o 1 różnicę między maksymalną a minimalną wartością, np. rozpiętość liczb w Dużym Lotku wynosi (49-1) + 1 = 49).
###### Wady
Największymi ograniczeniami algorytmu są konieczność uprzedniej znajomości zakresu danych(np. są to liczby całkowite z przedziału 0..100) i złożoność pamięciowa (wymaga dodatkowo O(k) lub O(n+k) pamięci).
[_Źródło_](https://en.wikipedia.org/wiki/Counting_sort)
