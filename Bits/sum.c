#include <stdio.h>

void add();
void subtract();

int main() {
    int choice;
    printf("Simple Addition and Subtraction Program\n");
    printf("1. Add\n");
    printf("2. Subtract\n");
    printf("Enter your choice: ");
    scanf("%d", &choice);

    switch (choice) {
        case 1:
            add();
            break;
        case 2:
            subtract();
            break;
        default:
            printf("Invalid choice! Please try again.\n");
    }

    return 0;
}

void add() {
    double num1, num2;
    printf("Enter two numbers to add: ");
    scanf("%lf %lf", &num1, &num2);
    printf("Result: %.2lf\n", num1 + num2);
}

void subtract() {
    double num1, num2;
    printf("Enter two numbers to subtract: ");
    scanf("%lf %lf", &num1, &num2);
    printf("Result: %.2lf\n", num1 - num2);
}
