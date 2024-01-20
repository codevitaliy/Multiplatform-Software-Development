#include <stdio.h>
#include <unistd.h>

int main() {

  char *programa = "ps";

  char *argumentos[] = {"ps","aux",NULL};

  execvp(programa, argumentos);

  perror("execvp");

  return 1;

}