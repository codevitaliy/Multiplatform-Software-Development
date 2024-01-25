#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include<sys/types.h>
#include <sys/wait.h>

/* Ejecución de un programa en el proceso hijo: Modifica el programa anterior para que, en lugar de imprimir un mensaje, el proceso hijo ejecute un programa 
diferente utilizando exec(). Por ejemplo, el proceso hijo podría ejecutar un programa que muestra la fecha y hora actual. 
Asegúrate de que el proceso padre todavía imprima su mensaje después de que el proceso hijo termine. */

int main() {

  pid_t pid;

  pid = fork();

  if(pid == -1) {
    perror("error creando");
    exit(EXIT_FAILURE);
  }


  if(pid == 0) { //es el proceso hijo

    char *nombre_comando = "date";
    char *argumentos[] = {"date",NULL};
    execvp(nombre_comando, argumentos);
    perror("error execvp");
    return 1;


  }else if(pid > 0)  { //es el proceso padre

    wait(NULL);
    printf("Soy el proceso padre pid: %d\n", getpid());
  }



  return 0;
}