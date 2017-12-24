#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#define MAXSIZE 25

struct Lista
{
  char string[MAXSIZE];
  struct Lista* next;
};
struct Lista* head;

void WSTAW(struct Lista **head, char mystring[MAXSIZE])
{
  struct Lista *aktual = malloc(sizeof *aktual);
  strcpy(aktual->string, mystring);
  aktual->next = (*head);
  *head = aktual;
}

void DRUKUJ(struct Lista *head) {
  struct Lista* aktual = head;
  while (aktual != NULL) {
      printf("%s\n", aktual->string);
      aktual = aktual->next;
  }
}

void KASUJ(struct Lista **head)
{
    struct Lista *aktual = *head;
    struct Lista *next;
    while (aktual != NULL)
    {
       next = aktual->next;
       free(aktual);
       aktual = next;
    }
    *head = NULL;
}

char* SZUKAJ(struct Lista **head, char mystring[MAXSIZE])
{
    struct Lista *temp = *head;
    struct Lista *next;
    while (temp != NULL)
    {
        if (strcmp(temp->string, mystring) == 0)
        {
            return temp->string;
        }
        temp = temp->next;
    }
    return "Nieznaleziono";
}

int USUN(struct Lista **head, char mystring[MAXSIZE])
{
    if (!head || !(*head))
        return -1;
    struct Lista *temp = *head;
    struct Lista *prev = NULL;
    while (strcmp(temp->string, mystring) != 0 && temp->next != NULL)
    {
        prev = temp;
        temp = temp->next;
    }
    if (strcmp(temp->string, mystring) == 0)
    {
        if (prev) {
            prev->next = temp->next;
        }
        else
        {
            *head = temp->next;
        }
        free(temp);
        return 0;
    }

    return -1;
}

int POWTORKI(struct Lista* lista, char string[MAXSIZE])
{
    int licznik = 0;
    while(lista != NULL)
    {
        if(strcmp(lista->string, string) == 0)
            licznik++;
        lista = lista->next;
    }
    return licznik;
}

struct Lista* BEZPOWTORZEN(struct Lista* lista)
{
        struct Lista* druga = NULL;
        while(lista != NULL)
        {
            if(POWTORKI(druga, lista->string) ==0)
                WSTAW(&druga, lista->string);
            lista = lista->next;
        }
        return druga;
}

int main(void)
{
    head = NULL;
    struct Lista* bezpowtorzen = NULL;
    WSTAW(&head, "Maslo");
    WSTAW(&head, "Orzechy");
    WSTAW(&head, "Czekolada");
    WSTAW(&head, "Puding");
    WSTAW(&head, "Maslanka");
    WSTAW(&head, "Puding");
    WSTAW(&head, "Wafelki");
    WSTAW(&head, "Puding");
    printf("%s \n", SZUKAJ(&head, "Orzechy"));
    printf("%s \n", SZUKAJ(&head, "Jogurt"));
    // KASUJ(&head);
    USUN(&head, "Wafelki");
    DRUKUJ(head);
    printf("======================= \n");
    bezpowtorzen = BEZPOWTORZEN(head);
    DRUKUJ(bezpowtorzen);
    return 0;
}
