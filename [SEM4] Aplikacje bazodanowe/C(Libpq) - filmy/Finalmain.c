#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<libpq-fe.h>


void doSQL(PGconn *conn, char *command)
{
  PGresult *result;

  printf("%s\n", command);

  result = PQexec(conn, command);
  printf("status is %s\n", PQresStatus(PQresultStatus(result)));
  printf("#rows affected %s\n", PQcmdTuples(result));
  printf("result message: %s\n", PQresultErrorMessage(result));

  switch(PQresultStatus(result)) {
  case PGRES_TUPLES_OK:
    {
      int m, n;
      int nrows = PQntuples(result);
      int nfields = PQnfields(result);
      printf("number of rows returned = %d\n", nrows);
      printf("number of fields returned = %d\n", nfields);
      for(m = 0; m < nrows; m++) {
	for(n = 0; n < nfields; n++)
	  printf(" %s = %s(%d),",
		 PQfname(result, n),
		 PQgetvalue(result, m, n),
		 // rozmiar pola w bajtach
		 PQgetlength(result, m, n));
	printf("\n");
      }
    }
  }
  PQclear(result);
}



int main(int ile_arg, char* arg[])
{
if(ile_arg==1) //dla wywolania ./program
{
  char nazwa_pliku[25];
  char login_uzyt[25];
  char haslo_uzyt[30];
  char baza_uzyt[25];
  int plik_petla=0;
  FILE* plik;
  puts("\n Witaj w systemie zarzadzania baza danych PostgreSQL - wersja tworzenia tabeli bazy z pliku .csv ");
  do
  {
    printf("\nPodaj nazwe pliku z rozrzerzeniem .csv \n");
    scanf("%s", nazwa_pliku);
    plik = fopen(nazwa_pliku, "r");
    if(plik == NULL)
    {
      printf("Blad otwarcia pliku, sprobuj ponownie");
    }
    else
    {
      plik_petla=1;
    }
  } while(plik_petla==0);

  PGconn *myconnection;
  char connectexec[150];
  do
  {
    strcpy(connectexec,"host=localhost port=5432 dbname=" );
    puts("Podaj nazwe bazy danych:");
    scanf("%s", baza_uzyt);
    strcat(connectexec,baza_uzyt);
    strcat(connectexec," user=");
    puts("Podaj login do bazy danych:");
    scanf("%s", login_uzyt);
    strcat(connectexec,login_uzyt);
    strcat(connectexec," password=");
    puts("Podaj haslo do bazy danych:");
    system("stty -echo");
    scanf("%s", haslo_uzyt);
    system("stty echo");
    strcat(connectexec,haslo_uzyt);
    // pr�ba po��czenia
    //myconnection = PQconnectdb("host=localhost port=5432 dbname=login_uzyt user=login_uzyt password=haslo_uzyt");
    myconnection = PQconnectdb(connectexec);
      // sprawdzamy status po��czenia
    if(PQstatus(myconnection) == CONNECTION_OK)
    {
      printf("connection made\n");
      // informacje o polaczeniu
      printf("PGDBNAME   = %s\n",PQdb(myconnection));
      printf("PGUSER     = %s\n",PQuser(myconnection));
      printf("PGPASSWORD = ********\n");
      printf("PGHOST     = %s\n",PQhost(myconnection));
      printf("PGPORT     = %s\n",PQport(myconnection));
      printf("OPTIONS    = %s\n",PQoptions(myconnection));
    }
    else
    {
      printf("connection failed: %s\n", PQerrorMessage(myconnection));
      puts("SPROBUJ PONOWNIE");
    }
// w razie utraty polaczenia wywolanie
// PQreset(myconnection);
// zamyka polaczenie i nawiazuje je raz jeszcze
// z dotychczasowymi parametrami
   }while(PQstatus(myconnection) != CONNECTION_OK);


  printf("\nTworze tabele i dodaje rekordy z pliku %s ... \n", nazwa_pliku);

  char nazwa_pliku_tabeli[25];
  int i=0;
  while(nazwa_pliku[i]!='.'){
    nazwa_pliku_tabeli[i]=nazwa_pliku[i];
    i++;
}

  char dropTable[100];
  memset(dropTable, 0, 100 * sizeof(char));
  strcat(dropTable, " DROP TABLE IF EXISTS ");
  strcat(dropTable, nazwa_pliku_tabeli);
  //strcat(dropTable, "Filmy");
  strcat(dropTable, ";");
  doSQL(myconnection, dropTable);
  //  doSQL(myconnection, "DROP TABLE IF EXISTS Film;");

  //TWORZENIE TABELI
  char krotka[30][50];
  char nazwykolumn[30][50];
  char line[200];
  const char srednik[2] = ";";
  fgets(line, sizeof line, plik);
  char *token;
  token = strtok(line, srednik);
  int iter = 0;
  while(token != NULL)
  {
    strcpy(krotka[iter], token);
    strcpy(nazwykolumn[iter],krotka[iter]);
    token = strtok(NULL, srednik);
    printf(" \n %s \n", krotka[iter]);
    iter++;
  }
  int ilosckolumn = iter-1;

  char queryHolder[1000];
  memset(queryHolder, 0, 1000 * sizeof(char));

  strcat(queryHolder, " CREATE TABLE ");
  strcat(queryHolder, nazwa_pliku_tabeli);
  //strcat(queryHolder, "Filmy");
  strcat(queryHolder,"(id SERIAL PRIMARY KEY, ");
  strcat(queryHolder, krotka[0]);
  strcat(queryHolder, " VARCHAR(20) NOT NULL UNIQUE, "); //bo rozni sie obecnoscia UNIQUE od pozostalych
  for(iter=1;iter<ilosckolumn-1;iter++)
  {
    strcat(queryHolder, krotka[iter]);
    strcat(queryHolder, " VARCHAR(20) DEFAULT NULL, ");   //srodkowa czesc zapytania, gdzie sa przecinki
  }
  strcat(queryHolder, krotka[ilosckolumn-1]);
  strcat(queryHolder, " VARCHAR(20) DEFAULT NULL); ");  //koniec zapytania
  doSQL(myconnection,queryHolder); //utworzenie tabeli
  //doSQL(myconnection, "CREATE TABLE Film (id SERIAL PRIMARY KEY, lp VARCHAR(20) NOT NULL UNIQUE, tytul VARCHAR(20) NOT NULL);");
  //INSERT WARTOSCI Z PLIKU

  while(feof(plik) == 0) //feof zwraca inna wartosc niz 0, gdy natrafi na koneic pliku
  {
    memset(queryHolder, 0, 1000 * sizeof(char)); //zerowanie tablicy queryHolder
    memset(line, 0, 200 * sizeof(char));
    fgets(line, sizeof line, plik);
    //memset(token, 0, sizeof(token) * sizeof(char));
    token = strtok(line, srednik);
    iter = 0;
    while(token != NULL)
    {
      strcpy(krotka[iter], token);
      token = strtok(NULL, srednik);
      iter++;
    }
    strcat(queryHolder, " INSERT INTO ");
    strcat(queryHolder, nazwa_pliku_tabeli);
    //strcat(queryHolder, "Filmy");
    strcat(queryHolder,"(");
    for(iter=0;iter<ilosckolumn-1;iter++) //wpisuje nazwy kolumn
    {
      strcat(queryHolder, nazwykolumn[iter]);
      strcat(queryHolder, ",");
    }
    strcat(queryHolder, nazwykolumn[ilosckolumn-1]);
    strcat(queryHolder, ") VALUES(");
    for(iter=0;iter<ilosckolumn-1;iter++) //wpisuje wartosci
    {
      strcat(queryHolder,"'");
      strcat(queryHolder, krotka[iter]);
      strcat(queryHolder, "',");
    }
    strcat(queryHolder,"'");
    strcat(queryHolder, krotka[ilosckolumn-1]);
    strcat(queryHolder, "');");

    //printf("\nZAPYTANIE INSERT INTO TABLE: \n %s\n", queryHolder);
    doSQL(myconnection,queryHolder); //dodanie rekordu tabeli :)

  }

  int insert_petla=0;
  int uzyt_wybor;
  while(insert_petla==0)
  {
      printf(" \n Jesli chcesz dodac rekord kliknij 1, jesli zakonczyc dzialanie programu kliknij 2 \n");
      memset(queryHolder, 0, 1000 * sizeof(char));
      scanf("%d", &uzyt_wybor);
      if(uzyt_wybor == 2)
      {
        break;
      }
      if(uzyt_wybor == 1)
      {
        puts("Wpisz zapytanie PSQL:");
        getchar();
        scanf("%[^\n]s", queryHolder);
        //printf("%s", queryHolder);
        doSQL(myconnection, queryHolder);
      }
    }
    fclose(plik);
    PQfinish(myconnection);
}

else //dla wywolania ./program nazwa_bazy nazwa_tabeli_1 ... nazwa_tabeli_n przekierowanie strona2.html
{
  PGconn *myconnection;
  char login_uzyt[25];
  char haslo_uzyt[30];
  char baza_uzyt[25];
  char connectexec[150];

  do
  {
    memset(login_uzyt, 0, 25 * sizeof(char));
    memset(haslo_uzyt, 0, 30 * sizeof(char));
    memset(baza_uzyt, 0, 25 * sizeof(char));
    memset(connectexec, 0, 150 * sizeof(char));
    strcat(connectexec,"host=localhost port=5432 dbname=" );
    strcat(baza_uzyt,arg[1]);
    strcat(connectexec,baza_uzyt);
    strcat(connectexec," user=");
    scanf("%s", login_uzyt);
    strcat(connectexec,login_uzyt);
    strcat(connectexec," password=");
    system("stty -echo");
    scanf("%s", haslo_uzyt);
    system("stty echo");
    strcat(connectexec,haslo_uzyt);
    // pr�ba po��czenia
    //myconnection = PQconnectdb("host=localhost port=5432 dbname=login_uzyt user=login_uzyt password=haslo_uzyt");
    myconnection = PQconnectdb(connectexec);

   }while(PQstatus(myconnection) != CONNECTION_OK);

  printf("<!DOCTYPE html><html><head><title>Tabelka</title><style>table { font-family: arial, sans-serif; border-collapse: collapse; width: 100%;}");
  printf("td, th { border: 1px solid #000000; text-align: left; padding: 8px;}tr:nth-child(even) { background-color: #48D1CC;}</style></head><body>");
  char select[200];
  PGresult *result;
  int iter_select,rows,fields,x,y;
  for(iter_select=2;iter_select<ile_arg;iter_select++)
  {

    printf("<table>\n");
    memset(select, 0, 200 * sizeof(char));
    strcat(select, "SELECT * FROM ");
    strcat(select, arg[iter_select]);
    strcat(select, ";");
    result = PQexec(myconnection, select);

    if(PQresultStatus(result)==PGRES_TUPLES_OK)
    {
      rows = PQntuples(result);
      fields = PQnfields(result);
      printf("<tr> \n");
      for(x=0; x<fields; x++)
      {
        printf(" <td> %s </td> \n", PQfname(result,x));
      }
      printf("</tr> \n");

      for(y=0; y<rows; y++)
      {
        printf("<tr> \n");
        for(x=0; x<fields; x++)
        {
          printf("<td> %s </td> \n", PQgetvalue(result,y,x));
        }
        printf("</tr> \n");
      }
     }
    else
    {
      printf("BLAD - w bazie nie ma tabeli %s", arg[iter_select]);
    }
    printf("</table>");
    PQclear(result);
  }
  printf("</body></html>");
  PQfinish(myconnection);
}




  return 0;
}
