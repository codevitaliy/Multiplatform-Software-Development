#include <stdio.h>
#include <unistd.h>

int main () {

  char *program = "date";

  execlp(program,program,NULL);

  perror("error");
  return 1;

}