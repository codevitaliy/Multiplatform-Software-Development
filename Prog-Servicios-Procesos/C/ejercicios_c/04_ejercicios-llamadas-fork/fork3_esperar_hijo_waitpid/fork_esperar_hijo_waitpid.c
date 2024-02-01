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


/*  Espera a que el proceso hijo termine: Crea un programa que utiliza fork() para crear un proceso hijo.
 Luego, el proceso padre debe esperar a que el proceso hijo termine antes de imprimir un mensaje final.
 Utiliza wait() o waitpid() para lograr esta espera. */

int main()
{

  pid_t pid;

  pid = fork();

  if (pid == -1)
  {
    perror("error creando fork");
    exit(EXIT_FAILURE);
  }

  if (pid == 0)
  {

    printf("Soy el hijo y mi pid es %d y mi ppid es %d\n", getpid(), getppid());
    sleep(2); // simulating some work
    exit(EXIT_SUCCESS);
  }
  else if (pid > 0)
  {

    int status;
    pid_t child_pid;

    child_pid = waitpid(pid, &status, 0); // &status almacena el estado de terminacion del proceso hijo
                                          // 0 indica que la funcion debe esperar a cualquier proceso hijo con el ID especificado por pid

    if (child_pid == -1)
    {
      perror("error in waitpid");
      exit(EXIT_FAILURE);
    }

    if (WIFEXITED(status))
    {
      printf("El hijo con PID %d terminó con estado: %d\n", child_pid, WEXITSTATUS(status));
    }
    else if (WIFSIGNALED(status))
    {
      printf("El hijo con PID %d terminó debido a una señal: %d\n", child_pid, WTERMSIG(status));
    }
  }

  return 0;
}