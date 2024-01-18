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
#define NUM_LENGTH 3

int main()
{

  srand(time(NULL));
  int fd[2];
  pid_t pid;

  if (pipe(fd) == - 1)
  {
    perror("Pipe error");
    exit(EXIT_FAILURE);
  }

  pid = fork();

  if (pid < 0)
  {
    perror("Fork error");
    exit(EXIT_FAILURE);
  }

  if (pid == 0)
  {

    int received_rand_numbers[NUM_LENGTH];
    

    close(fd[WRITE]);

    for (int i = 0; i < NUM_LENGTH; i++)
    {
      read(fd[READ], &received_rand_numbers[i], sizeof(int));
    }

    /*for (int i = 0; i < NUM_LENGTH; i++)
    {
      printf("Numero:%d, %d\n", i, received_rand_numbers[i]);
    }

    */

   
  }else if (pid > 0)
  {

    close(fd[READ]);

    int rand_number;

    for (int i = 0; i < NUM_LENGTH; i++)
    {
      rand_number = rand();
      write(fd[WRITE], &rand_number, sizeof(int));
    }

    close(fd[WRITE]);

    wait(NULL);
  }

  return 0;
}