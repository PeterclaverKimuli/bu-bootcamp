#include <stdio.h>

/* Pass by value: the function gets a copy. Original is unchanged. */
void try_double_value(int x)
{
    x *= 2;
    printf("Inside function: %d\n", x);
}

/* Pass by pointer: the function gets the address. Can modify the original. */
void actually_double(int *x)
{
    *x *= 2;
}

int main()
{
    int x = 42;    /* a regular integer variable */
    int *ptr = &x; /* ptr is a pointer to int, storing the address of x */

    printf("x = %d\n", x);
    printf("&x = %p\n", &x);     /* address of x, e.g. 0x1000 */
    printf("ptr = %p\n", ptr);   /* same address: ptr holds &x */
    printf("*ptr = %d\n", *ptr); /* 42: dereference ptr to get value at that address */

    *ptr = 100; /*change the value AT the address ptr points to*/

    printf("x after = %d\n", x); /* 100: x has changed! */

    int n = 5;

    try_double_value(n);
    printf("After by-value:   %d\n", n);

    actually_double(&n);
    printf("After by-pointer: %d\n", n);

    return 0;
}