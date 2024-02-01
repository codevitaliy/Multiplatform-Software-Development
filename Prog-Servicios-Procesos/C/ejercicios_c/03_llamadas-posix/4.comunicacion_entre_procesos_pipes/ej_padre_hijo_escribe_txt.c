#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <math.h> // USING POW NEED gcc -o program program.c -lm
#define READ 0
#define WRITE 1
#define FD_LENGTH 2



//Crea un programa que creee dos procesos. El proceso padre enviará al hijo un número que lee del usuario, 
//el hijo lo eleva al cubo y lo escribe en salida.txt.

int main() {

  int fd[FD_LENGTH];

  pid_t pid;

  if(pipe(fd) == -1){
    perror("pipe");
    exit(EXIT_FAILURE);
  }

  pid = fork();

  if (pid == -1){
    perror("fork");
    exit(EXIT_FAILURE);
  }

  if(pid == 0) { // hijo

    double received_number = 0, cubo = 0;

    close(fd[WRITE]);

    read(fd[READ], &received_number, sizeof(received_number));

    close(fd[READ]);

    cubo = pow(received_number, 3); // USING POW NEED gcc -o program program.c -lm
    
    // or received_number * received_number * received_number

    FILE* archive = fopen("output.txt", "w");

    //COMPROBACION DE APERTURA DE ARCHIVO

    if(archive == NULL) {
      perror("error al abrir el archivo txt");
      exit(EXIT_FAILURE);
    } 

    fprintf(archive, "%lf", cubo);

    fclose(archive);


  }else if (pid > 0) { //padre

    double input_number = 0;

    close(fd[READ]);

    scanf("%lf", &input_number);

    write(fd[WRITE], &input_number, sizeof(input_number));

    close(fd[WRITE]);

    wait(NULL);

    printf("Soy el padre y he terminado despues del hijo");

  }

  return 0;
}