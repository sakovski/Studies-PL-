INSERT INTO Klient( imie, nazwisko, pesel,telefon,kod_pocztowy) VALUES('Maciej','Testowy',94022398842,'867-486-223','11-042');
INSERT INTO Klient(imie, nazwisko, pesel,telefon,kod_pocztowy) VALUES('Janusz','Kowalski',91021393391,'777-222-225','13-043');
INSERT INTO Klient(imie, nazwisko, pesel,telefon,kod_pocztowy) VALUES('Kamil','Adamczyk',87021234391,'654-486-228','15-044');
INSERT INTO Klient(imie, nazwisko, pesel,telefon,kod_pocztowy) VALUES('Zygmunt','Nowak',91021238888,'567-422-244','17-045');
INSERT INTO Klient(imie, nazwisko, pesel,telefon,kod_pocztowy) VALUES('Zygmunt','Nkaak',9111238888,'567-411-244','17-045');


INSERT INTO Producent(nazwa,kraj,rok_otwarcia,NIP,zatrudnienie) VALUES('Bosch','Niemcy',1956,0000786543,31490);
INSERT INTO Producent(nazwa,kraj,rok_otwarcia,NIP,zatrudnienie) VALUES('Ursus','Czechy',1988,0000467898,19456);
INSERT INTO Producent(nazwa,kraj,rok_otwarcia,NIP,zatrudnienie) VALUES('Reserved','Holandia',1990,0000568902,8976);
INSERT INTO Producent(nazwa,kraj,rok_otwarcia,NIP,zatrudnienie) VALUES('Danon','Polska',2000,0000112345,4500);
SELECT * FROM Producent;

INSERT INTO Kosiarka(marka,model,waga,rocznik,cena,Producent_id) VALUES('Wolf Garten','A 340 E 1400',30.5,2008,599.99,1);
INSERT INTO Kosiarka(marka,model,waga,rocznik,cena,Producent_id) VALUES('URL','S48625E',15.5,2010,1999.99,2);
INSERT INTO Kosiarka(marka,model,waga,rocznik,cena,Producent_id) VALUES('NAC','A 340 E 1400',40.4,2010,599.99,3);
INSERT INTO Kosiarka(marka,model,waga,rocznik,cena,Producent_id) VALUES('Trawokosiacz','4000',50.5,2002,599.99,4);
SELECT * FROM Kosiarka;

INSERT INTO Transakcja(data,platnosc,uwagi,Klient_id,Kosiarka_id) VALUES(2017-05-23,'karta','brak',1,2);
INSERT INTO Transakcja(data,platnosc,uwagi,Klient_id,Kosiarka_id) VALUES(2017-05-24,'gotówka','Wymiana ostrzy potrzeba',2,2);
INSERT INTO Transakcja(data,platnosc,uwagi,Klient_id,Kosiarka_id) VALUES(2017-05-25,'karta','brak',3,1);
INSERT INTO Transakcja(data,platnosc,uwagi,Klient_id,Kosiarka_id) VALUES(2017-05-25,'gotówka','brak',3,4);
SELECT * FROM Transakcja;

DROP TABLE Transakcja;
DROP TABLE Klient;
DROP TABLE Kosiarka;
DROP TABLE Producent;