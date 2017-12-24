#include<stdio.h>
#include<stdlib.h>

#define T 3 //stopieñ drzewa
//x - wêze³ B-drzewa

int mini=T-1;
int maxi=(2*T)-1;
int t=T;

struct bdrzewo
{
    int n; //ilosc kluczy
    int klucz[2*T]; //klucze(wstawiamy od 1)
    int lisc; //czy lisc
    struct bdrzewo *c[2*T+1]; //tab wskaznikow do synow
};

struct bdrzewo *przydziel_pamiec(void)
{
    return (struct bdrzewo *)malloc(sizeof(struct bdrzewo));
}

struct bdrzewo *korzen;

void wyswietl_bdrzewo(struct bdrzewo *x)
{
    int i;
    for(i=1; i<x->n+1; i++)
        printf(" %d ", x->klucz[i]);
    printf("\n");
    if(x->lisc != 1)
        for(i=1; i<x->n+2; i++)
            wyswietl_bdrzewo(x->c[i]);
}
/*
void drukujB(struct bdrzewo *x, int p)
{
  // drukuje B-drzewo o korzeniu r (pozycja w pliku)
  // wydruk przesuniety o p w prawo
  int i,j;
  if (x->lisc){ //jesli 0 - false(nie lisc), jesli 1 - true(lisc)
    for (i=0;i<p;i++) printf(" ");
    for (i=1;i<(x->n)+1;i++) printf("%d ",x->klucz[i]);
    printf("\n");
  } else {
    drukujB(x->c[x->n],p+4);
    for (i=(x->n)-1;i>=0;i--){
      for (j=1;j<p+1;j++) printf(" ");
      printf("%d\n",x->klucz[i]);
      drukujB(x->c[i],p+4);
    }
  }
}
*/
void bdrzewa_usuwanie(struct bdrzewo **pocz,int k)
{
    struct bdrzewo *x= *pocz;
    int i;
    if(!x->lisc && x->n==1 && x->c[1]->n==mini && x->c[2]->n==mini)
    {
        struct bdrzewo *y= x->c[1];
        struct bdrzewo *z= x->c[2];
        y->klucz[t]= x->klucz[1];
        for(i=1; i<t; i++)
        {
            y->klucz[t+i]= z->klucz[i];
            y->c[t+i]= z->c[i];
        }
        y->c[t+i]= z->c[i];
        y->n= maxi;
        *pocz= y;
        free(x);
        usuwanie(y,k);
    }
    else usuwanie(x,k);
    return;
}

void usuwanie(struct bdrzewo *x,int k)
{
    int i=1;
    int j;
    while(i<(x->n+1) && k>x->klucz[i]) i= i+1;
    if(i<(x->n+1) && k==x->klucz[i]) //jesli znaleziony zostal klucz w wezle x
    {
        if(x->lisc)//jesli x lisciem
        {
            for(j=i; j<x->n; j++)
            x->klucz[j]= x->klucz[j+1];
            x->n-=1;
            printf("\nKlucz %d usunieto\n", k);
        }
        else//jesli x wezlem wewnetrznym
        {
            struct bdrzewo *y= x->c[i];
            struct bdrzewo *z= x->c[i+1];
            if(y->n > mini)
            {
                int kk= y->klucz[y->n];
                x->klucz[i]= kk;
                bdrzewa_usuwanie(&y,kk);
            }
            else
            if(z->n > mini)
            {
                int kk = z->klucz[1];
                x->klucz[i]= kk;
                bdrzewa_usuwanie(&z,kk);
            }
            else
            {
                y->klucz[t]= k;
                for(j=1; j<t; j++)
                {
                    y->klucz[t+j]= z->klucz[j];
                    y->c[t+j]= z->c[j];
                }
                y->c[2*t]=z->c[t];
                y->n= maxi;
                for(j=i; j<x->n; j++)
                {
                    x->klucz[i]= x->klucz[i+1];
                    x->c[i+1]= x->c[i+2];
                }
                x->n-=1;
                bdrzewa_usuwanie(&y,k);
            }
        }
    }
    else if(x->lisc)//jesli x lisciem i nie ma klucza
        {
            printf("\n %d NOT FOUND\n",k);
            return;
        }
        else//jesli k nie jest w x i x jest wezlem wewnetrznym
        {
            if(x->c[i]->n > mini) bdrzewa_usuwanie(&(x->c[i]), k);
            else if((i>1) && (x->c[i-1]->n > mini))
                {
                    struct bdrzewo *b= x->c[i-1];
                    struct bdrzewo *ten= x->c[i];
                    for(j=mini;j>0;j--)
                    {
                        ten->klucz[j+1]=ten->klucz[j];
                        ten->c[j+2]= ten->c[j+1];
                    }
                    ten->c[2]= ten->c[1];
                    ten->n+=1;
                    ten->c[1]= b->c[b->n+1];
                    ten->klucz[1]= x->klucz[i-1];
                    x->klucz[i-1]= b->klucz[b->n];
                    b->n-=1;
                    bdrzewa_usuwanie(&ten,k);
                }
                else if((i < x->n+1) && (x->c[i+1]->n >mini))
                    {
                        struct bdrzewo *b= x->c[i+1];
                        struct bdrzewo *ten= x->c[i];
                        ten->n+=1;
                        ten->klucz[t]= x->klucz[i];
                        ten->c[t+1]= b->c[1];
                        x->klucz[i]= b->klucz[1];
                        for(j=1; j<b->n; j++)
                        {
                            b->klucz[j]= b->klucz[j+1];
                            b->c[j]= b->c[j+1];
                        }
                        b->c[b->n]= b->c[b->n+1];
                        b->n-=1;
                        bdrzewa_usuwanie(&ten,k);
                    }
                    else
                    {
                        struct bdrzewo *y= NULL;
                        struct bdrzewo *z= NULL;
                        if(i < x->n+1 && x->c[i+1]->n==mini)
                        {
                            y= x->c[i];
                            z= x->c[i+1];
                            y->klucz[t]= x->klucz[i];
                            for(j=i; j<x->n; j++)
                            {
                                x->klucz[j]= x->klucz[j+1];
                                x->c[j+1]= x->c[j+2];
                            }
                        }
                        else
                        {
                            y= x->c[i-1];
                            z= x->c[i];
                            y->klucz[t]= x->klucz[i-1];
                            for(j=i-1; j<x->n; j++)
                            {
                                x->klucz[j]= x->klucz[j+1];
                                x->c[j+1]= x->c[j+2];
                            }
                        }
                        x->n-=1;
                        for(j=1; j<t; j++)
                        {
                            y->klucz[t+j]= z->klucz[j];
                            y->c[t+j]= z->c[j];
                        }
                        y->c[t+j]= z->c[j];
                        y->n= maxi;
                        free(z);
                        usuwanie(y,k);
                    }
        }
        return;
}

void wstawianie_podzial_synow(struct bdrzewo *x,int i,struct bdrzewo *y)
{
    struct bdrzewo *z=przydziel_pamiec();
    int j;
    z->lisc= y->lisc;
    z->n= mini;
    for(j=1; j<t; j++)
        z->klucz[j]= y->klucz[t+j];
    if(!y->lisc)
    {
        for(j=1; j<t+1; j++)
            z->c[j]= y->c[t+j];
    }
    y->n=mini;
    for(j=(x->n+1); j>i; j--)
        x->c[j+1]= x->c[j];
    x->c[i+1]= z;
    for(j=x->n; j>i-1; j--)
        x->klucz[j+1]= x->klucz[j];
    x->klucz[i]= y->klucz[t];
    x->n+=1;
    return;
}

void wstawianie_niep(struct bdrzewo *x, int klucz)
{
    int i = x->n;
    if(x->lisc)
    {
        while(i>0 && klucz<x->klucz[i])
        {
            x->klucz[i+1]= x->klucz[i];
            i-=1;
        }
        x->klucz[i+1]= klucz;
        x->n+=1;
        printf("\n %d INSERTED.\n",klucz);
    }
    else
    {
        while(i>0 && klucz<x->klucz[i])
        i-=1;
        i+=1;
        if(x->c[i]->n==maxi)
        {
            wstawianie_podzial_synow(x,i,x->c[i]);
            if(klucz>x->klucz[i]) i=i+1;
        }
        wstawianie_niep(x->c[i],klucz);
    }
    return;
}

void wstawianie(struct bdrzewo **pocz, int klucz)
{
    struct bdrzewo *r=*pocz;
    if(r->n==maxi)
    {
        struct bdrzewo *nowywezel=przydziel_pamiec();
        *pocz= nowywezel;
        nowywezel->lisc= 0;
        nowywezel->n= 0;
        nowywezel->c[1]= r;
        wstawianie_podzial_synow(nowywezel,1,r);
        wstawianie_niep(nowywezel,klucz);
    }
    else
    wstawianie_niep(r,klucz);
    return;
}

void tworzenie_bdrzewa(struct bdrzewo **pocz)
{
    struct bdrzewo *x= przydziel_pamiec();
    x->lisc= 1;
    x->n= 0;
    *pocz= x;
    wstawianie(&korzen,18);
    wstawianie(&korzen,30);
    wstawianie(&korzen,10);
    wstawianie(&korzen,19);
    wstawianie(&korzen,21);
    wstawianie(&korzen,23);
    wstawianie(&korzen,36);
    wstawianie(&korzen,33);
    wstawianie(&korzen,2);
    wstawianie(&korzen,13);
    wstawianie(&korzen,66);
    return;
}

int wyszukaj_element(struct bdrzewo *x, int klucz) //0 - nie znaleziono, 1- znaleziono
{
    int i = 1;
    while(i<(x->n+1) && klucz>x->klucz[i])
        i= i+1;
    if(i<(x->n+1) && klucz==x->klucz[i])
    {
        return 1;
    }
    if(x->lisc)
    {
        return 0;
    }
    else
    return wyszukaj_element(x->c[i],klucz);
}

int main()
{
    korzen=NULL;
    tworzenie_bdrzewa(&korzen);

    system("clear");
    int main_petla = 0;
    int wybor;
    int elem_wybor;
    while(main_petla==0)
    {
    printf("\n1.INSERT \n");
    printf("2.SEARCH \n");
    printf("3.PRINT \n");
    printf("4.DELETE \n");
    printf("5.EXIT \n");
    scanf("%d", &wybor);

        if(wybor==1)
        {
            printf("\n INSERT ELEMENT: ");
            scanf("%d",&elem_wybor);
            wstawianie(&korzen,elem_wybor);
        }
        if(wybor==2)
        {
            printf("\nSEARCH ELEMENT: ");
            scanf("%d",&elem_wybor);

            if(wyszukaj_element(korzen,elem_wybor)==1)
            {
                int i=1;
                printf("\n\%d FOUND\n\n", elem_wybor);
            }
            else
                printf("\n%d NOT FOUND\n", elem_wybor);
        }
        if(wybor==3)
        {
            printf("\n\nTREE:\n\n");
            wyswietl_bdrzewo(korzen);
            //drukujB(korzen,0);

        }
        if(wybor==4)
        {
            printf("\nDELETE ELEMENT: ");
            scanf("%d",&elem_wybor);
            bdrzewa_usuwanie(&korzen,elem_wybor);
        }
        if(wybor==5)
            break;
    }
    return 0;
}
