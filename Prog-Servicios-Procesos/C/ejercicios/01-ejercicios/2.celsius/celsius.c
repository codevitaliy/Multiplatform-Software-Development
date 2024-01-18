#include <stdio.h>     // Entrada/salida estándar
#include <stdlib.h>    // Funciones de la biblioteca estándar
#include <signal.h>    // Manejo de señales
#include <string.h>    // Funciones de manipulación de cadenas
#include <math.h>      // Funciones matemáticas
#include <ctype.h>     // Funciones de caracteres
#include <time.h>      // Funciones relacionadas con el tiempo
#include <unistd.h>    // Llamadas al sistema estándar de Unix
#include <fcntl.h>     // Operaciones de control de archivos
#include <sys/types.h> // Tipos de datos específicos del sistema
#include <sys/stat.h>  // Funciones relacionadas con la información del archivo
#include <errno.h>     // Códigos de error
#include <sys/wait.h>  // Esperar al hijo
#include <sys/types.h> // Para los pid y ppid;

int main()
{

  /* -- SCANF VERSION --

  int celsius, fahrenheit;

  printf("Enter the temperature: \n");

  scanf("%d", &celsius);

  fahrenheit = (celsius * 9/5) + 32;

  printf("Celcius: %d, Fahrentheit: %d \n", celsius, fahrenheit);

  */

   //-- FGETS VERSION WITH ATOI


  char str_celsius[100]; // *celsius, char celsius[20] delcaration must have the size of the array or char celsius[] = "25";

  float celsius, fahrenheit;

  printf("Enter the temperature: \n");

  fgets(str_celsius, sizeof(str_celsius), stdin);

  celsius = atoi(str_celsius);

  fahrenheit = (celsius * 9/5) + 32;

  printf("Celsius: %.2f, Fahrenheit: %.2f \n", celsius, fahrenheit);

  

  // Declarar variables

  return 0;
}