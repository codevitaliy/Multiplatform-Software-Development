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

#define STRING_LENGTH 100

int main()
{

  char string[STRING_LENGTH];

  int vowel_counter_lowercase = 0, vowel_counter_uppercase = 0;

  printf("Enter a string: \n");

  scanf("%s", string);

  for (int i = 0; i < STRING_LENGTH && string[i] != '\0'; i++)

  {
    switch (string[i])
    {
    case 'a':
    case 'e':
    case 'i':
    case 'o':
    case 'u':
      vowel_counter_lowercase++;
      break;
        case 'A':
        case 'E':
        case 'I':
        case 'O':
        case 'U':
        vowel_counter_uppercase++;
      break;
    default:
    break;
    
    }
  }

  printf("Number of lowercase vowels: %d, Number of uppercase vowels: %d\n", vowel_counter_lowercase, vowel_counter_uppercase);

  return 0;
}
