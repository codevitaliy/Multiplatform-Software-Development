#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>

int main () {

  char *nombre_archivo = "output.txt";
  char *nombre_programa = "ls";
  char *argumentos[] = {"ls", "/home", NULL};

  int file = open(nombre_archivo, O_WRONLY | O_CREAT | O_TRUNC, 0644);

  if (file < 0) {
    perror("open error");
    return 1;
  }

  dup2(file, STDOUT_FILENO);

  close(nombre_archivo);

  execvp(nombre_programa, argumentos);

  perror("execvp error");
  
  return 1;
}