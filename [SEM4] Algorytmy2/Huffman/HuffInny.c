#include <stdio.h>
#include <string.h>

typedef struct node_t {
    struct node_t *left, *right;
    int freq; //czestotliwosc wystapien
    char c;
} *node;

struct node_t pool[256] = {{0}};
node qqq[255], *q = qqq - 1;
int n_nodes = 0, qend = 1;
char *code[128] = {0}, buf[1024];

node create_node(int freq, char c, node a, node b)
{
    node n = pool + n_nodes++;
    if (freq) n->c = c, n->freq = freq;
    else {
        n->left = a, n->right = b;
        n->freq = a->freq + b->freq;
    }
    return n;
}

/* kolejka */
void insert(node n)
{
    int j, i = qend++;
    while ((j = i / 2)) {
        if (q[j]->freq <= n->freq)
            break; //wyjscie z petli
        q[i] = q[j], i = j;
    }
    q[i] = n;
}

node qremove()
{
    int i, l;
    node n = q[i = 1];

    if (qend < 2) return 0;
    qend--;
    while ((l = i * 2) < qend) {
        if (l + 1 < qend && q[l + 1]->freq < q[l]->freq) l++;
        q[i] = q[l], i = l;
    }
    q[i] = q[qend];
    return n;
}

/* wstawianie 0 i 1  */
void build_code(node n, char *s, int len)
{
    static char *out = buf;
    if (n->c) {
        s[len] = 0;
        strcpy(out, s);
        code[n->c] = out;
        out += len + 1;
        return;
    }

    s[len] = '0'; build_code(n->left,  s, len + 1);
    s[len] = '1'; build_code(n->right, s, len + 1);
}

void init(const char *s)
{
    int i, freq[128] = {0};
    char c[16];
    printf("\n");
    while (*s)
    {
      freq[(int)*s++]++; //zliczanie cz�sto�ci wyst�pie�
    }

    for (i = 0; i < 128; i++)
        if (freq[i])
        {
            insert(create_node(freq[i], i, 0, 0));
            printf("'%c' : %d\n", i, freq[i]); //wypisz czestosci wystapien znaku
        }
    while (qend > 2)
        insert(create_node(0, 0, qremove(), qremove()));

    build_code(q[1], c, 0);
}

void encode(const char *s, char *out)
{
    while (*s)
    {
        strcpy(out, code[*s]);
        out += strlen(code[*s++]);
    }
}

int decode(const char *s, node t)
{
    node n = t;
    int i = 0;
    while (*s)
    {
        if (*s++ == '0')
          n = n->left;
        else
          n = n->right;

        if (n->c)
        {
          i++;
          putchar(n->c);
          n = t;
        }
    }

    putchar('\n');
    if (t != n)
      printf("garbage input\n");
    return i;
}

int main(void)
{
    int i;
    char filename[20];
    FILE *input, *output;
    char buf[1024];
    char str[1024];

    printf("Podaj nazwe pliku wejsciowego: \n");
    scanf("%s",filename);
    input = fopen(filename, "r");
    output = fopen("output.txt","w");
    fgets(str,1024,input);
    printf("\n Czestosci wystapien i kody: \n");
    init(str);

    for (i=0; i<128; i++)
    {
        if (code[i])
        {
            printf("'%c': %s\n", i, code[i]);
        }
    }

    encode(str, buf);
    printf("Zakodowany tekst: %s\n", buf);
    fprintf(output,"%s", buf);
    printf("Ilosc znakow: %ld\n", strlen(buf));
    printf("Odkodowany tekst: ");
    printf("Ilosc znakow: %d \n", decode(buf, q[1])*8);

    fclose(input);
    fclose(output);

    return 0;
}
