#include <stdio.h>
#include <unistd.h>

int main() {

  //nombre del programa a ejecutar

  char *nombre_programa = "ip";

  //ejectura argumento para el programa

  char *argumentos[] = {"ip", "a", NULL}; //array de argumentos de tipo char 

  //ejecutar el comando 

  execvp(nombre_programa, argumentos); //codigo despues de execvp si se ejecuta bien, no lo lee ni lo ejecuta 

  perror("execvp");

  return 1;
}