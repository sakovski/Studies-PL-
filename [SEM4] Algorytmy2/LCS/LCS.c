#include<stdio.h>
#include<string.h>
#include<stdlib.h>

int c[20][20]; //liczby
char x[20]; //ciag 1
char y[20]; //ciag 2
char b[20][20]; // znaki
int m; //liczniki dlugosci
int n;

void print(int i,int j)
{
    if(i==0 || j==0)
        return;
    if(b[i][j]=='\\')
    {
        print(i-1,j-1);
        printf("%c",x[i-1]);
    }
    else if(b[i][j]=='|')
        print(i-1,j);
    else
        print(i,j-1);
}

void lcs()
{
    int i, j;
    m=strlen(x);
    n=strlen(y);

    for(i=0;i<=m;i++)
    {
         c[i][0]=0;
    }

    for(i=0;i<=n;i++)
    {
        c[0][i]=0;
    }

    for(i=1;i<=m;i++)
    {
        for(j=1;j<=n;j++)
        {
            if(x[i-1]==y[j-1])
            {
                    c[i][j]=c[i-1][j-1]+1;
                    b[i][j]='\\';
            }
            else if(c[i-1][j]>=c[i][j-1])
            {
                    c[i][j]=c[i-1][j];
                    b[i][j]='|'; //z gory
            }
            else
            {
                    c[i][j]=c[i][j-1];
                    b[i][j]='-'; //z lewej
            }
        }
    }
}

int main()
{
     printf("Podaj pierwszy ciag:");
     scanf("%s",x);
     printf("Podaj drugi ciag:");
     scanf("%s",y);
     printf("\nNajdluzszy podciag: ");
     lcs();
     print(m,n);
     return 0;
}
