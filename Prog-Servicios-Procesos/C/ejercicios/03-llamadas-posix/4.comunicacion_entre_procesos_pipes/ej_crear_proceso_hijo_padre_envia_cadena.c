#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#define READ 0
#define WRITE 1
#define NUM_FD 2

// Crea un programa que creee dos procesos. El proceso padre enviará al hijo una cadena de texto.

int main()
{

  int fd[NUM_FD];

  pid_t pid;

  // ahora toca crear el pipe

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

  if (pid == 0) { //PROCESO HIJO == 0
    
    char *string_child;

    close(fd[WRITE]);

    read(fd[READ], &string_child, sizeof(string_child));

    printf("%s", string_child);

    exit(EXIT_SUCCESS);


  }else if(pid != 0) { // PROCESO PADRE ES != 0

    char *string_father = "Mi padre es el mejor\n";


    //cerramos el pipe de lectura

    close(fd[READ]);

    //escribimos el numero en el pipe de escritura directamente

    write(fd[WRITE], &string_father, sizeof(string_father));

    //importante cerrar luego todo 

    close(fd[WRITE]);

    // esperamos a que el hijo termine su trabajo antes de que lo haga el padre

    wait(NULL);

    printf("Proceso padre ha terminado\n");
  }

  return 0;
}