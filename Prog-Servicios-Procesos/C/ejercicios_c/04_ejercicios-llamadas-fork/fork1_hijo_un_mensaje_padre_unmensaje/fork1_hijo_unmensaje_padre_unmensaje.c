#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include<sys/types.h>
#include <sys/wait.h>

/* Creación de un proceso hijo: Escribe un programa en C que utilice fork() para crear un proceso hijo. 
El proceso hijo debe imprimir un mensaje como "Soy el proceso hijo" y el proceso padre debe imprimir 
"Soy el proceso padre". Asegúrate de que ambos procesos se ejecuten correctamente y muestren su 
respectivo mensaje.
 */
int main(){

  pid_t pid; 

  pid = fork();

  if(pid == -1) {
    perror("error creando fork");
    exit(EXIT_FAILURE);
  }

  if(pid == 0) { // son los hijos

    printf("Soy el hijo mi pid es: %d, y el ppid es: %d\n", getpid(), getppid());

  }else if (pid > 0) { // es el padre

    wait(NULL);
    printf("Soy el padre y mi pid es %d, y ppid es %d\n", getpid(), getppid());

  }

  return 0;
}