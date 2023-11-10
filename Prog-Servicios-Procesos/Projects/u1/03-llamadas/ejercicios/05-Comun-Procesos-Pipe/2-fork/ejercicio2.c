#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <math.h>

#define READ 0
#define WRITE 1
#define CUBO 3

int main()
{

  int fd[2];

  if (pipe(fd) == -1)
  {
    perror("Error creating pipe");
    exit(EXIT_FAILURE);
  }

  pid_t pid;

  if ((pid = fork()) == -1)
  {
    perror("Error creating the fork");
    exit(EXIT_FAILURE);
  }

  if (pid != 0)
  {
    // Proceso padre
    int inputNumber;
    printf("Enter a number: ");
    scanf("%d", &inputNumber);

    close(fd[READ]); // Cerramos el extremo de lectura, ya que no lo usaremos en el padre

    write(fd[WRITE], &inputNumber, sizeof(inputNumber));
    close(fd[WRITE]); // Cerramos el extremo de escritura después de escribir el número

    wait(NULL); // Esperamos a que el hijo termine
  }
  else
  {
    // Proceso hijo
    int receivedNumber;

    close(fd[WRITE]); // Cerramos el extremo de escritura, ya que no lo usaremos en el hijo

    read(fd[READ], &receivedNumber, sizeof(receivedNumber));
    close(fd[READ]); // Cerramos el extremo de lectura después de leer el número

    // Calculamos el cubo y lo imprimimos en la consola
    receivedNumber = pow(receivedNumber, CUBO);
    printf("Cubed number in the child process: %d\n", receivedNumber);

    // Abrimos el archivo para escribir el resultado
    FILE *file = fopen("output.txt", "w");
    if (file == NULL)
    {
      perror("Error opening the file");
      exit(EXIT_FAILURE);
    }

    fprintf(file, "%d", receivedNumber);

    fclose(file);

    // exit(EXIT_SUCCESS);  // Salimos del proceso hijo
  }

  return 0; // Fin del programa principal
}
