#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>


int main() {

  pid_t pid;

  pid = fork();

  if(pid == -1) {
    perror("Error al crear al hijo");
    return 1;
  }

  if(pid == 0) {
    printf("Soy el pid hijo: %d\n",getpid());
  }else{

    wait(NULL);
    printf("Soy el pid padre: %d\n",getpid());
    
  }
  
  return 0;

}