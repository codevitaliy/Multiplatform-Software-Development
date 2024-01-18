#include <stdio.h>
#include <stdlib.h>

int main() {

  /* VERSION WITH SCANF

  int num1, num2, result;

  printf("Enter first number \n");

  scanf("%d", &num1);

  printf("Enter second number  \n");

  scanf("%d", &num2);

  result = num1 + num2;

  printf("Result: %d\n", result);

  */

  /*

  char num1char[100], num2char[100];
  int num1, num2, result;

  printf("Enter the first number \n");
  fgets(num1char, sizeof(num1char), stdin);

  printf("Enter the second number \n");
  fgets(num2char, sizeof(num2char), stdin);

  num1 = atoi(num1char);
  num2 = atoi(num2char);

  result = num1 + num2; 

  printf("Result: %d\n", result);

  */

   char input;
    int suma = 0;

    printf("Ingrese caracteres para sumar (presione 'q' para salir):\n");

    do {
        input = getchar();

        // Verificar si el carácter es un dígito antes de sumarlo
        if (input >= '0' && input <= '9') {
            suma += (input - '0'); // Convertir el carácter a valor numérico
        }

    } while (input != 'q');

    printf("Suma acumulativa: %d\n", suma);

  return 0;
}