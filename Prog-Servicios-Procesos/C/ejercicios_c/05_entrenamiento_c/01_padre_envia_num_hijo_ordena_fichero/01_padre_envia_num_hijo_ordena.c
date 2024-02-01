#include <stdio.h>     // Entrada/salida estándar
#include <stdlib.h>    // Funciones de la biblioteca estándar
#include <signal.h>    // Manejo de señales
#include <string.h>    // Funciones de manipulación de cadenas
#include <math.h>      // Funciones matemáticas ---- gcc your_program.c -o your_program -lm ----
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
#define ALEATORY_NUMBERS 3
#define BUFFER_SIZE 100

int main(int argc, char *argv[])
{

  srand(time(NULL));

  int fd[2];

  pid_t pid;

  if (pipe(fd) == -1)
  {
    perror("error pipe");
    exit(EXIT_FAILURE);
  }

  pid = fork();

  if (pid == -1)
  {
    perror("fork error");
    exit(EXIT_FAILURE);
  }
  else if (pid == 0)
  { // codigo hijo

    int array_numbers[ALEATORY_NUMBERS];

    close(fd[WRITE]);

    for (int i = 0; i < ALEATORY_NUMBERS; i++)
    {

      read(fd[READ], &array_numbers[i], sizeof(array_numbers[i]));
    }

    close(fd[READ]);

    int num_one = array_numbers[0], num_two = array_numbers[1], num_three = array_numbers[2], num_aux;

    printf("%d , %d, %d\n", num_one, num_two, num_three);

    if (num_one >= num_two && num_one >= num_three)
    {
      if (num_two >= num_three)
      {
        printf("1. %d, 2. %d, 3. %d\n", num_one, num_two, num_three);
      }
      else if (num_two <= num_three)
      {
        printf("1. %d, 2. %d, 3. %d\n", num_one, num_three, num_two);
        num_aux = num_three;
        num_three = num_two;
        num_two = num_aux;
      }
    }

    if (num_two >= num_one && num_two >= num_three)
    {
      if (num_one >= num_three)
      {
        printf("1. %d, 2. %d, 3. %d\n", num_two, num_one, num_three);
        num_aux = num_one;
        num_one = num_two;
        num_two = num_aux;
      }
      else if (num_one <= num_three)
      {
        printf("1. %d, 2. %d, 3. %d\n", num_two, num_three, num_one);
        num_aux = num_one;
        num_one = num_two;
        num_two = num_three;
        num_three = num_aux;
      }
    }

    if (num_three >= num_one && num_three >= num_two)
    {
      if (num_one >= num_two)
      {
        printf("1. %d, 2. %d, 3. %d\n", num_three, num_one, num_two);
        num_aux = num_one;
        num_one = num_three;
        num_three = num_two;
        num_two = num_aux;
      }
      else if (num_one <= num_two)
      {
        printf("1. %d, 2. %d, 3. %d\n", num_three, num_two, num_one);
        num_aux = num_one;
        num_one = num_three;
        num_three = num_aux;

      }
    }

    FILE* archivo = fopen("num_order.txt", "w");

    if(archivo == NULL){
      perror("error leyendo archivo txt");
      return 1;
    }

    char stringOrden[BUFFER_SIZE];

    sprintf(stringOrden, "1. %d, 2. %d, 3 %d", num_one, num_two, num_three);

    fprintf(archivo,"%s", stringOrden);

    fclose(archivo);

    return 0;


  }
  else
  { // codigo del padre

    close(fd[READ]);

    int rand_number = 0;

    for (int i = 0; i < ALEATORY_NUMBERS; i++)
    {

      rand_number = rand();
      write(fd[WRITE], &rand_number, sizeof(rand_number));
    }

    close(fd[WRITE]);

    wait(NULL);
  }

  return 0;
}