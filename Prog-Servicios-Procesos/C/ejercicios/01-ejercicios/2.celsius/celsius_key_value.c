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

#define MAP_LENGTH 50
#define CELSIUS_KEY_LENGTH 10

struct celsius_key_value
{
  int celsius_key;
  int fahrenheit_value;
};

int main() {

  struct celsius_key_value map[MAP_LENGTH];

  for (int i = 0; i < MAP_LENGTH; i++)
  {
    map[i].celsius_key = i - 20;
    map[i].fahrenheit_value = ((i - 20) * 9/5) + 32;
  }

  /* printf("CELSIUS || FAHRENHEIT\n");

  for (int i = 0; i < MAP_LENGTH; i++) {
    
    printf("%d, || %d\n", map[i].celsius_key, map[i].fahrenheit_value);
  }
  */

  printf("Enter a celsius temperature to get the fahrenheit\n");

  int celsius;

  scanf("%d",&celsius);

  for (int i = 0; i < MAP_LENGTH; i++)
  {
    if (map[i].celsius_key == celsius) {
      printf("%d", map[i].fahrenheit_value);
    }
  }
}
