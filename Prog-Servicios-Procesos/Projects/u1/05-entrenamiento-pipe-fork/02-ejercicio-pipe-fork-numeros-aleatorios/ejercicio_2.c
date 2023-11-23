#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <time.h>

#define READ 0
#define WRITE 1
#define NUM_SONS 2
#define ARRAY_MAX_LENGTH 20
#define MAX_NUMBER 100
#define NUM_ONE 1

int main()
{
  srand(time(NULL));

  int pipe_child_1[2], pipe_child_2[2];

  if (pipe(pipe_child_1) == -1 || pipe(pipe_child_2) == -1)
  {
    perror("pipe");
    exit(EXIT_FAILURE);
  }

  pid_t pid_child_1, pid_child_2 = 0; // Initialize pid_child_2

  pid_child_1 = fork();

  if (pid_child_1 == 0)
  {
    // codigo del hijo 1

    close(pipe_child_1[WRITE]);

    int receivedNumber;

    // Correct the pipe descriptor to read from
    read(pipe_child_1[READ], &receivedNumber, sizeof(int));

    close(pipe_child_1[READ]);

    printf("El hijo 1: recibe numero par: %d\n", receivedNumber);
  }
  else
  {
    // padre crea segundo hijo
    pid_child_2 = fork();

    if (pid_child_2 == 0)
    {
      // codigo del hijo 2

      int receivedNumber;

      // Close the unused write end of pipe_child_2
      close(pipe_child_2[WRITE]);

      // Correct the pipe descriptor to read from
      read(pipe_child_2[READ], &receivedNumber, sizeof(int));

      close(pipe_child_2[READ]);

      printf("El hijo 2: recibe numero inpar: %d\n", receivedNumber);
    }

    // Close unused pipe ends in the parent
    close(pipe_child_1[READ]);
    close(pipe_child_2[READ]);

    int randomNumber;

    for (size_t i = 0; i < ARRAY_MAX_LENGTH; i++)
    {
      randomNumber = rand() % MAX_NUMBER + 1;

      if ((randomNumber % 2) == 0)
      {
        write(pipe_child_1[WRITE], &randomNumber, sizeof(int));
      }
      else
      {
        write(pipe_child_2[WRITE], &randomNumber, sizeof(int));
      }
    }

    // Close the write ends after writing
    close(pipe_child_1[WRITE]);
    close(pipe_child_2[WRITE]);

    // Wait for both child processes to finish
    wait(NULL);
    wait(NULL);
  }

  return 0;
}
