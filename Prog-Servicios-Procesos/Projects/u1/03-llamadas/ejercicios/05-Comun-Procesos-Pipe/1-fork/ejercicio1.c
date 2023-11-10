#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

// Crea un proceso que cree un proceso hijo, el envíe 3 números enteros aleatorios a través de un pipe. 
// El proceso hijo los ordenará y los escribirá en el fichero salida.txt.

#define READ 0
#define WRITE 1

int main() {

  int fd[2];

  if(pipe(fd) == -1) {
    perror("error creando el pipe");
    exit(EXIT_FAILURE);
  }

  pid_t pid = fork();

  if(pid == -1) {
    perror("error creando el fork");
    exit(EXIT_FAILURE);

  }

  if(pid != 0) {

    close(fd[READ]);

    char *messageSent = "Hello my son";

    write(fd[WRITE], &messageSent, sizeof(messageSent));

    close(fd[WRITE]);

    wait(NULL);

  }else {

    char *messageRead;

    close(fd[WRITE]);

    read(fd[READ], &messageRead, sizeof(messageRead));

    close(fd[READ]);

    printf("I am the son: and my father sent me: %s", messageRead);
    
    exit(EXIT_SUCCESS);

  }
}