#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {

  pid_t pid;

  pid = fork();

  if(pid == -1) {
    perror("error creating the son");
    return 1;
  }

  if(pid == 0) 
	{
    char *command = "date";
    execlp(command,command,NULL);
  }
	else 
	{
    printf("El padre espera al hijo: %d",getpid());
    wait(NULL);
  }

  return 0;
	
}