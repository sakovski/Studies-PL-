#include <stdio.h>
float a, b;
float m_c(float a, float b);
float c_m(float a, float b);
float k_m(float a, float b);
float m_k(float a, float b);

int main(void)
{
puts("Jezeli chcesz zamienic metry na cale wcisnij 1.");
puts("Jezeli chcesz zamienic cale na metry wcisnij 2.");
puts("Jezeli chcesz zamienic kilometry na mile ladowe wcisnij 3.");
puts("Jezeli chcesz zamienic mile ladowe na kilometry wcisnij 4.");
int x;
scanf("%d", &x);
switch(x)
{
case 1:
m_c(a, b);
break;
case 2:
c_m(a, b);
break;
k_m(a, b);
case 3:
break;
m_k(a, b);
case 4:
break;
}
return 0;
}

float m_c(float a, float b)
{
puts("Podaj wartosc w metrach");
scanf("%f", &a);
b = a / 0.0254;
printf("Wynik: %f\n", b);
return b;
}
float c_m(float a, float b)
{
puts("Podaj wartosc w calach");
scanf("%f", &a);
b = a * 0.0254;
printf("Wynik: %f\n", b);
return b;
}
float k_m(float a, float b)
{
puts("Podaj wartosc w kilometrach");
scanf("%f", &a);
b =  a / 1.61;
printf("Wynik: %f\n", b);
return b;
}
float m_k(float a, float b)
{
puts("Podaj wartosc w milach");
scanf("%f", &a);
b = a * 1.61;
printf("Wynik: %f\n", b);
return b;
}
