#include <stdio.h>
#include <math.h>

#define false 0
#define true 1

int main() {
    int number = 0;
    int checked_number = true;  // Inicializado a true

    printf("Enter a number to check if it is prime: ");
    scanf("%d", &number);

    if (number <= 1) {
        checked_number = false;  // Números menores o iguales a 1 no son primos
    } else {
        double sqrt_number = sqrt(number);

        for (int i = 2; i <= sqrt_number; i++) {
            if (number % i == 0) {
                checked_number = false;
                break;
            }
        }
    }

    if (checked_number == true) {
        printf("Es primo\n");
    } else {
        printf("No es primo\n");
    }

    return 0;
}
