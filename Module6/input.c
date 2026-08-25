#include <stdio.h>

int main()
{
    int age;
    double salary;

    printf("Enter your age: ");
    scanf("%d", &age); /* & required: scanf writes to the address of age */

    printf("Enter your salary: ");
    scanf("%lf", &salary); /* %lf for double with scanf (not %f) */

    printf("\nAge: %d, Salary: %.2f\n", age, salary);

    return 0;
}