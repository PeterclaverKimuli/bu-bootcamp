#include <stdio.h>

void swap(int *a, int *b);
void swap_doubles(double *a, double *b);
void swap_chars(char *a, char *b);

void broken_swap(int a, int b);

int main()
{
    /*Correct swap*/
    int x = 10, y = 20;
    double a = 12.5, b = 13.5;
    char d = 'A', e = 'B';

    printf("===== Correct Swap =====\n");
    printf("Before swap: x = %d, y = %d\n", x, y);
    printf("Before swap: a = %.2f, b = %.2f\n", a, b);
    printf("Before swap: d = %c, e = %c\n\n", d, e);

    swap(&x, &y);
    swap_doubles(&a, &b);
    swap_chars(&d, &e);

    printf("After swap: x = %d, y = %d\n", x, y);
    printf("After swap: a = %.2f, b = %.2f\n", a, b);
    printf("After swap: d = %c, e = %c\n\n", d, e);

    printf("===== Broken Swap =====\n");
    /*Broken swap: because the function receives copies, not addresses. */
    int w = 30, z = 40;

    printf("Before swap: w = %d, z = %d\n", w, z);

    broken_swap(w, z);

    printf("After swap: w = %d, z = %d", w, z);

    return 0;
}

void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

void swap_doubles(double *a, double *b)
{
    double temp = *a;
    *a = *b;
    *b = temp;
}

void swap_chars(char *a, char *b)
{
    char temp = *a;
    *a = *b;
    *b = temp;
}

void broken_swap(int a, int b)
{
    int temp = a;
    a = b;
    b = temp;
}