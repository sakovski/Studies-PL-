
#include<stdio.h>
#include<stdlib.h>

struct wezel
{
    int klucz;
    int licznik;
    struct wezel *lewy, *prawy;
};

// nowy wezel
struct wezel *nowywezel(int item)
{
    struct wezel *temp =  (struct wezel *)malloc(sizeof(struct wezel));
    temp->klucz = item;
    temp->lewy = temp->prawy = NULL;
    temp->licznik;
    return temp;
}

struct wezel* WSTAW(struct wezel* wezel, int klucz)
{
    /* jesli drzewo jest puste utworz nowe */
    if (wezel == NULL)
      return nowywezel(klucz);
    if (klucz == wezel->klucz)
    {
       (wezel->licznik)++;   // jesli klucz istnieje zwieszka licznik
       return wezel;
    }

    if (klucz < wezel->klucz)  //jesli nie to przeszukuje drzewo
        wezel->lewy  = WSTAW(wezel->lewy, klucz);
    else
        wezel->prawy = WSTAW(wezel->prawy, klucz);

    return wezel;
}

struct wezel* SZUKAJ(struct wezel *root, int klucz)
{
  // korzen jest pusty lub szukany klucz jest w korzeniu
  if(root == NULL || root->klucz == klucz)
  {
    return root;
  }
  // Klucz jest wiekszy niz korzen
  if(root->klucz < klucz)
  {
    return SZUKAJ(root->prawy, klucz);
  }
  return SZUKAJ(root->lewy, klucz);
}

//Szukanie najmniejszej wartosci we wskazanym wezle
struct wezel * minValuewezel(struct wezel* wezel)
{
    struct wezel* current = wezel;
    /* szukanie najbardziej lewego syna */
    while (current->lewy != NULL)
        current = current->lewy;

    return current;
}

struct wezel* USUN(struct wezel* root, int klucz)
{
    // jesli pustaprzdatne do usuwanie elementowuniety jest mniejszy niz korzen to lezy w lewym poddrzewie
    if (klucz < root->klucz)
    {
        root->lewy = USUN(root->lewy, klucz);
    }
    // Jesli klucz, ktora ma byc usuniety jest wiekszy niz korzen to lezy w prawym poddrzewie
    else if (klucz > root->klucz)
    {
        root->prawy = USUN(root->prawy, klucz);
    }
    //jesli klucz ojca jest taki sam jak szukany klucz, to jest to wezel do usuniecia
    else
    {
      // Jesli licznik klucza jest >= 1 obniz
      if (root->licznik >= 1)
      {
         (root->licznik)--;
         return root;
      }

        // wezel z jednym synem lub bez synow
        if (root->lewy == NULL)
        {
            struct wezel *temp = root->prawy;
            free(root);
            return temp;
        }
        else if (root->prawy == NULL)
        {
            struct wezel *temp = root->lewy;
            free(root);
            return temp;
        }

        // wezel z dwoma synami, szukanie najmniejszego elementu w prawym poddrzewie
        struct wezel* temp = minValuewezel(root->prawy);

        // Skopiuj najmniejszy element do tymczasowego wezla
        root->klucz = temp->klucz;

        //Usun najmniejszy element z drzewa
        root->prawy = USUN(root->prawy, temp->klucz);
    }
    return root;
}

void DRUKUJ(struct wezel *root)
{
    if (root != NULL)
    {
        DRUKUJ(root->lewy);
        printf("%d(%d) ; ", root->klucz, root->licznik);
        DRUKUJ(root->prawy);
    }
}

int main()
{
    int wybor;
    int i;
    int n;
    int a;
    struct wezel *root = NULL;
    struct wezel *tmp = NULL; // do szukania
    for(i=-1; i<0; i--){

    printf("\n1.WSTAW \n");
    printf("2.USUN \n");
    printf("3.SZUKAJ \n");
    printf("4.DRUKUJ \n");
    printf("5.ZAMKNIJ \n");
    scanf("%d", &wybor);
    switch(wybor) {
      case 1:
    root = WSTAW(root, 45);
    root = WSTAW(root, 54);
    root = WSTAW(root, 2);
    root = WSTAW(root, 12);
    root = WSTAW(root, 33);
    root = WSTAW(root, 180);
    root = WSTAW(root, 2);
    root = WSTAW(root, 2);
    printf("Drukuje drzewo \n");
    DRUKUJ(root);
    break;
      case 2:
    printf("\nUsuwam:\n");
    scanf("%d,", &n);
    root = USUN(root, n);
    printf("Drukuje drzewo \n");
    DRUKUJ(root);
    break;
      case 3:
    printf("\nSzukam: \n");
    scanf("%d", &a);
    tmp = SZUKAJ(root, a);
    if(tmp)
      printf("Znaleziono klucz");
    else
      printf("Nie znaleziono klucza");
      break;
      case 4:
    printf("Drukuje drzewo \n");
    DRUKUJ(root);
    break;
      case 5:
        i=2;
        break;
    }
  }
  return 0;
}
