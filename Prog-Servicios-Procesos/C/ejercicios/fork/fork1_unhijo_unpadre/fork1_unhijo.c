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

#define READ 0
#define WRITE 1

int main()
{

  int fd[2];
  pid_t pid;

  if (pipe(fd) == -1)
  {
    perror("pipe error");
    exit(EXIT_FAILURE);
  }

  pid = fork();

  if (pid == -1)
  {
    perror("fork error");
    exit(EXIT_FAILURE);
  }

  if (pid == 0)
  {

    printf("Soy el proceso hijo: %d y mi padre es %d\n", getpid(), getppid());
  }
  else
  {

    wait(NULL);
    printf("Soy el proceso padre: %d\n", getpid());
  }
}
