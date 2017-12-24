
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//Niekorzystne rozmiary tablic:
//#define M 4096  // Zerowe:3036, Max:13, Avg:3.53
//#define M 9012   // Zerowe:6629, Max:7, Avg:1.57
//#define M 10000     //Zerowe:7478, Max:6, Avg:1.48
//Korzystne rozmiary tablic:
//#define M 3163       //Zerowe:1137, Max:8, Avg:1.85
//#define M 6121     //Zerowe:3880, Max:8, Avg: 1.67
#define M 9949      //Zerowe: 7414 ,Max: 6,  Avg: 1.48


int haszowanie(char *s)
{
        int len = strlen(s);
        int i, kluczint = 0;
        for(i = 0; i < len-1; i=i+2)
        {
                kluczint ^= ((256*s[i])+s[i+1]);  //funkcja zamieniajaca string na liczbe
        }

        if(s[i]!=0)
        {
                kluczint ^= (256*s[i]);
        }
        return (int)(kluczint % M);
}

int main()
{
        int T[M];
        //wczytanie z pliku + haszowanie
        int i, indeks;
        char kluczstring[100];

        for(i=0; i<M; i++) //zerowanie tablicy T
        {
           T[i]=0;
        }

        FILE *plik;
        if((plik=fopen("3700.txt", "r"))==NULL)
        {
            printf("Nie moge otworzyc pliku\n");
            exit(1);
        }

        while(fscanf(plik, "%s", kluczstring)!=EOF)
        {
            indeks = haszowanie(kluczstring);
            T[indeks]++;
        }
        fclose(plik);

        //wypisanie wyniku
        int j,zera=0,maks=0;
        float avg = 0;

        for(j=0; j<M; j++)
        {
                if(T[j]==0)
                {
                    zera++;
                }
                else if(T[j]>maks)
                {
                    maks = T[j];
                }
                avg+=T[j];
        }

        int bezZer=M-zera;
        float srednia = avg/bezZer;
        printf("Zerowe pozycje: %d\nMaksymalna wartosc: %d\nSrednia wartosc: %.2lf\n\n",zera,maks,srednia);
        return 0;
}
