#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <math.h>
#include <time.h>

// Crea un proceso que cree un proceso hijo, el envíe 3 números enteros aleatorios a través de un pipe.
// El proceso hijo los ordenará y los escribirá en el fichero salida.txt.

#define READ 0
#define WRITE 1
#define MAX_RANDOM 100
#define MAX_NUMBERS 3
#define NUM_ONE 1

int main()
{
  srand(time(NULL));

  int fd[2];

  if (pipe(fd) == -1)
  {
    perror("error creating pipe");
    exit(EXIT_FAILURE);
  }

  pid_t pid;

  if ((pid = fork()) == -1)
  {
    perror("error creating fork");
    exit(EXIT_FAILURE);
  }

  if (pid == 0)
  {

    close(fd[WRITE]);

    int random1, random2, random3;

    int receivedArray[MAX_NUMBERS];

    read(fd[READ], &receivedArray, sizeof(receivedArray));

    close(fd[READ]);

    for (size_t i = 0; i < MAX_NUMBERS; i++)
    {
      if(i == 0) {
        random1 = receivedArray[i];
      }else if(i == 1) {
        random2 = receivedArray[i];
      }else if(i == 2) {
        random3 = receivedArray[i];
      }  
    }
    
  }
  else
  {

    close(fd[READ]);

    srand(time(NULL));

    int numbersArray[MAX_NUMBERS];

    for (size_t i = 0; i < MAX_NUMBERS; i++)
    {
      numbersArray[i] = rand() % MAX_NUMBERS + NUM_ONE;
    }

    write(fd[WRITE], &numbersArray, sizeof(numbersArray));

    close(fd[WRITE]);

    wait(NULL);
  }

  return 0;
}
