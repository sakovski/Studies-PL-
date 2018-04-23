# Testowanie aplikacji JAVA 2017-2018
## Projekt 1 (JUnit, narzędzie Hamcrest oraz MAVEN)

-----------------------

## Travis CI
[![Build Status](https://travis-ci.com/TestowanieJAVA2017-2018Gr3/projekt1-sakovski.svg?token=ZoNpgtoCyELsp2h1fsEL&branch=master)](https://travis-ci.com/TestowanieJAVA2017-2018Gr3/projekt1-sakovski)

-----------------------

**PROJEKT** (15 pkt)

Napiszmy program, który pozwalać będzie na przemieszczanie się statkiem po morzu. Morze ma wyspy na które statek nie może wpłynąć.
Wymagania do tego programu są następujące:
- Określone są punkt początkowy(x,y) statku oraz jego kierunek (N -> północ, S -> południe, E -> wschód, W -> zachód).
- Dodaj obsługę poleceń przesuwających statek naprzód (n) i wstecz (w).
- Dodaj polecenia powodujące obrót statku w lewo (l) i prawo (p).
- Statek przyjmuje łańcuch znaków z poleceniami (literami: n,w,l,p oznaczającymi odpowiednio naprzód,
wstecz, lewo, prawo).
- Dodaj obsługę wykrywania lądu. Wykrywanie powinno odbywać się przed każdym ruchem na
nową pozycję. Jeśli polecenie wymaga wpłynięcia na ląd, statek ma anulować ruch, pozostać
na obecnej pozycji i zgłosić napotkane przeszkody.
- Dodaj możliwość zapisu mapy do pliku oraz odtworzenia mapy z pliku.

Pod ocenę będą brane pod uwagę następujące elementy:
- (1 pkt) Kompilacja i uruchomienie bezbłędne projektu.
- (2 pkt) Uwzględnienie powyższych wymagań.
- (5 pkt) Przypadki testowe.
- (1 pkt) Użycie różnych asercji.
- (1 pkt) Uwzględnienie wyjątków.
- (1 pkt) Zastosowanie biblioteki Hamcrest.
- (1 pkt) Pokrycie kodu.
- (1 pkt) Styl kodu.
- (1 pkt) Zastosowanie metodyki TDD.
- (1 pkt) Zastosowanie testów parametrycznych.

Ponadto dodatkowo pod uwagę będą brane następujące elementy:

- (1 pkt) Użycie biblioteki AssertJ.
- (1 pkt) Skonfigurowanie TravisCI do automatycznego budowania projektu.
- (1 pkt) Zastosowanie testów parametrycznych przy użyciu plików testowych.
- (1 pkt) Zastosowanie JAVA 8 lub wyżej.
- (2 pkt) Zastosowanie dodatkowych różnych wymagań do gry.
- (2 pkt) Użycie innych technologii nie pokazywanych na zajęciach.

Ponadto pod ocenę jest brane również: (Brak tych elementów: -1 pkt za
podpunkt od obowiązkowej punktacji zadania!)
- Historia projektu w repozytorium.
- Ocena opisu commitów
- Stan repozytorium (żeby nie był śmietnikiem!!!)

-------------------------
