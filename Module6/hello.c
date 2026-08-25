#include <stdio.h>

/* Forward declarations (prototypes)*/
int add(int a, int b);
void print_result(int sum, int product);

int main()
{
    int age = 34;
    double salary = 95000.50;
    char initial = 'A';

    printf("Hello from C!\n\n");

    printf("Age: %d\n", age);         /* integer */
    printf("Salary: %.3f\n", salary); /* float, 3 decimal places */
    printf("Initial: %c\n", initial); /* single character */
    printf("Hex: %x\n", age);         /* integer in hexadecimal */
    printf("Width: %8d\n", age);      /* right-aligned in 8 characters */
    printf("%s\n\n", "a string");     /* string */

    int score = 20;

    if (score >= 90)
        printf("Grade is A\n\n");
    else if (score >= 80)
        printf("Grade is B\n\n");
    else
        printf("Grade is Fail\n\n");

    for (int i = 0; i < 5; i++)
        printf("%d\n", i);

    printf("\n");

    int x = 6, y = 7;
    int s = add(x, y);

    print_result(s, x * y);

    return 0;
}

int add(int a, int b)
{
    return a + b;
}

void print_result(int sum, int product)
{
    printf("Sum: %d\n", sum);
    printf("Product: %d\n", product);
}