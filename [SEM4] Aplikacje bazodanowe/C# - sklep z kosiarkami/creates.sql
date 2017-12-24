CREATE
  TABLE Klient
  (
    id       INTEGER NOT NULL IDENTITY(1,1) PRIMARY KEY,
    imie     VARCHAR (30) NOT NULL ,
    nazwisko VARCHAR (40) NOT NULL ,
    pesel BIGINT NOT NULL UNIQUE  ,
    telefon      VARCHAR (11) NOT NULL UNIQUE ,
    kod_pocztowy VARCHAR (6) NOT NULL
  )
GO

CREATE
  TABLE Kosiarka
  (
    id    INTEGER NOT NULL IDENTITY(1,1) PRIMARY KEY,
    marka VARCHAR (30) NOT NULL ,
    model VARCHAR (30) NOT NULL UNIQUE,
    waga FLOAT (8) NOT NULL ,
    rocznik INTEGER NOT NULL ,
    cena MONEY ,
    Producent_id INTEGER NOT NULL
  )

GO

CREATE
  TABLE Producent
  (
    id           INTEGER NOT NULL IDENTITY(1,1) PRIMARY KEY,
    nazwa        VARCHAR (30) NOT NULL UNIQUE,
    kraj         VARCHAR (30) NOT NULL ,
    rok_otwarcia INTEGER NOT NULL ,
    NIP BIGINT NOT NULL UNIQUE,
    zatrudnienie INTEGER NOT NULL
  )
GO

CREATE
  TABLE Transakcja
  (
    id          INTEGER NOT NULL IDENTITY(1,1) PRIMARY KEY,
    data        DATETIME NOT NULL ,
    platnosc    VARCHAR (10) NOT NULL ,
    uwagi       VARCHAR (100) NOT NULL ,
    Klient_id   INTEGER NOT NULL ,
    Kosiarka_id INTEGER NOT NULL
  )
GO
ALTER TABLE Kosiarka
ADD CONSTRAINT Kosiarka_Producent_FK FOREIGN KEY
(
Producent_id
)
REFERENCES Producent
(
id
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO

ALTER TABLE Transakcja
ADD CONSTRAINT Transakcja_Klient_FK FOREIGN KEY
(
Klient_id
)
REFERENCES Klient
(
id
)
ON
DELETE CASCADE ON
UPDATE NO ACTION
GO

ALTER TABLE Transakcja
ADD CONSTRAINT Transakcja_Kosiarka_FK FOREIGN KEY
(
Kosiarka_id
)
REFERENCES Kosiarka
(
id
)
ON
DELETE
  NO ACTION ON
UPDATE NO ACTION
GO
