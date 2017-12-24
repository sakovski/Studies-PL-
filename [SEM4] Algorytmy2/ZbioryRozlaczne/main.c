#include<stdio.h>
#include<stdlib.h>

typedef struct wezel {
  int key;
  struct wezel *parent;
  int rank;
}* Wezel;

Wezel MakeSet(int k)
{
  Wezel x = (struct wezel*) malloc(sizeof(struct wezel));
  x->key=k;
  x->parent=x;
  x->rank=0;
  return x;
}

Wezel FindSet(Wezel x)
{
  if(x != x->parent)
  {
    x->parent = FindSet(x->parent);
  }
  return x->parent;
}

void Union(Wezel x, Wezel y)
{
  if(x->rank > y->rank)
  {
    y->parent = x;
  }
  else
  {
    x->parent = y;
    if(x->rank==y->rank)
    {
      y->rank = y->rank+1;
    }
  }
}

int main(void)
{
  Wezel zero = MakeSet(0);
  Wezel jeden = MakeSet(1);
  Wezel dwa = MakeSet(2);
  Wezel trzy = MakeSet(3);
  Wezel cztery = MakeSet(4);
  Wezel piec = MakeSet(5);
  Wezel szesc = MakeSet(6);
  Wezel siedem = MakeSet(7);
  Wezel osiem = MakeSet(8);
  Wezel dziewiec = MakeSet(9);
  printf("MakeSet test: \n");
  printf("k:%d r:%d k:%d r:%d k:%d r:%d k:%d r:%d\n", zero->key, zero->rank, jeden->key, jeden->rank, dwa->key, dwa->rank, trzy->key, trzy->rank);
  printf("Union test \n");
  /* z zadania 1.
  Union(FindSet(zero),FindSet(jeden));
  Union(FindSet(dwa),FindSet(trzy));
  Union(FindSet(jeden),FindSet(dwa));
  Union(FindSet(piec),FindSet(szesc));
  Union(FindSet(siedem),FindSet(osiem));
  Union(FindSet(trzy),FindSet(piec));
  Union(FindSet(zero),FindSet(siedem));
  */
  //z przykladu dr Paczkowskiego
  printf("Polaczone zbiory o rownych rangach:\n");
  Union(FindSet(jeden), FindSet(dwa));
  printf("Union(FindSet(jeden), FindSet(dwa));\n");
  printf("jeden- key:%d rank:%d\ndwa- key:%d rank:%d\ndwa->parent->key:%d\njeden->parent->key:%d\n", jeden->key, jeden->rank, dwa->key, dwa->rank, dwa->parent->key, jeden->parent->key);
  Union(FindSet(trzy), FindSet(cztery));

  printf("Polaczone zbiory o roznych rangach:\n");
  Union(FindSet(piec), FindSet(cztery));
  printf("Union(FindSet(piec), FindSet(cztery));\n");
  printf("piec- key:%d rank:%d\ncztery- key:%d rank:%d\ncztery->parent->key:%d\npiec->parent->key:%d\ntrzy->parent->key:%d\n", piec->key, piec->rank, cztery->key, cztery->rank, cztery->parent->key, piec->parent->key, trzy->parent->key);

  return 0;
}
