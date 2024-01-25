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

#define NUM_PROCESOS 3

/* Uso de valores de retorno: Modifica el programa para que cada proceso hijo devuelva un valor de salida 
diferente utilizando exit(). 
El proceso padre debe recoger estos valores de salida utilizando wait() o waitpid() y mostrarlos en su salida. */

int main()
{

  int status;
  pid_t pid;

  for (int i = 0; i < NUM_PROCESOS; i++)
  {

    pid = fork();

    if (pid == -1)
    {
      perror("error creando fork");
      exit(EXIT_FAILURE);
    }
    else if (pid == 0)
    {

      switch (i)
      {
      case 0:
        printf("Soy el hijo numero 1, mi pid es %d, y ppid %d\n", getpid(), getppid());
        exit(i + 1);
        break;
      case 1:
        printf("Soy el hijo numero 2, mi pid es %d, y ppid %d\n", getpid(), getppid());
        exit(i + 1);
        break;
      case 2:
        printf("Soy el hijo numero 3, mi pid es %d, y ppid %d\n", getpid(), getppid());
        exit(i + 1);
        break;
      default:
        perror("Error switch");
        break;
      }
    }
    
  }

  for (int i = 0; i < NUM_PROCESOS; i++)
  {
    pid_t child_pid;
    child_pid = waitpid(-1, &status, 0);

    if (WIFEXITED(status))
    {
      int exit_status = WEXITSTATUS(status);
      printf("Proceso hijo con PID %d terminó con estado de salida: %d\n", child_pid, exit_status);
    }
    else
    {
      printf("Error en la finalización del proceso hijo con PID %d\n", child_pid);
    }
  }

   printf("Proceso padre con PID %d: Todos los hijos han terminado.\n", getpid());


  return 0;
}