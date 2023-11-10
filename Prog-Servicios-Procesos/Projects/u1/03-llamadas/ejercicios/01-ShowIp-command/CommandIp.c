#include <stdio.h>      // Include the standard input/output header
#include <unistd.h>     // Include the POSIX operating system API header

int main() {

  //Name of the executing program
  char *program = "ip";

  //Arguments for the program: program's name, "a", and NULL at the end;
  char *arguments[] = {"ip", "a", NULL};

  //Call execvp it executes the program with the arguments
  execvp(program, arguments);

  //If it fails, it'll print an error message
  perror("execvp");

  return 1;
}