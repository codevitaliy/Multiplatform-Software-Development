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

/* 
Creación de múltiples procesos hijos: Modifica el programa para que el proceso padre cree varios procesos 
hijos en lugar de uno solo. Cada proceso hijo debe realizar una tarea diferente o imprimir un mensaje único. 
Asegúrate de que el proceso padre espere a que todos los hijos terminen antes de finalizar. */

#define NUM_PROCESOS 3

int main() {

  pid_t pid;

  for(int i = 0; i < NUM_PROCESOS; i++) {

    pid = fork();

    if (pid == -1) {
      perror("error creando fork");
      exit(EXIT_FAILURE);
    } else if (pid == 0) {

      switch (i)
      {
      case 0:
        printf("Soy el hijo numero 1, mi pid es %d, y ppid %d\n", getpid(), getppid());
        break;
      case 1:
        printf("Soy el hijo numero 2, mi pid es %d, y ppid %d\n", getpid(), getppid());
        break;
      case 2:
        printf("Soy el hijo numero 3, mi pid es %d, y ppid %d\n", getpid(), getppid());
        break;
      default:
        printf("error en el switch");
        break;
      }
      exit(EXIT_SUCCESS); // IMPORTANTE PARA SALIR DEL CODIGO DEL HIJO PARA QUE NO SE SIGA EJECUTANDO DESPUES DEL 
   }
  }

  for(int i = 0; i < NUM_PROCESOS; i++){
    wait(NULL);
   }

   printf("Soy el proceso padre: pid %d\n", getpid());






  return 0;
}