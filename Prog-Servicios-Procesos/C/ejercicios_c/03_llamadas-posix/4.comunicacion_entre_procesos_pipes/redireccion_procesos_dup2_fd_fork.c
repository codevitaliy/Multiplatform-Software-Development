#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

#define READ 0
#define WRITE 1

/* Implementa un programa en C que utilice la llamada al sistema fork y la redirección de la salida estándar para
ejecutar el comando "ls -la" en un proceso hijo. El programa padre debe leer la salida del comando desde un pipe
creado entre los procesos y mostrarla en la consola. Asegúrate de manejar adecuadamente la creación del pipe,
la ejecución del comando usando execvp, y la lectura desde el pipe en el proceso padre.*/

int main()
{

  int fd[2];

  pid_t pid;

  if (pipe(fd) == -1)
  {
    perror("error creando pipe");
    exit(EXIT_FAILURE);
  }

  pid = fork();

  if (pid == -1)
  {
    perror("error creando fork");
    exit(EXIT_FAILURE);
  }

  if (pid == 0)
  { // codigo hijo

    close(fd[READ]);

    dup2(fd[WRITE], STDOUT_FILENO);

    close(fd[WRITE]);

    char *comando = "ls";
    char *argumentos[] = {"ls", "-l", "-a", NULL};

    execvp(comando, argumentos);

    perror("error ejecutando execvp");
  }
  else if (pid > 0)
  { // codigo padre

    char buffer[1024];
    ssize_t bytes;

    /*bytes se utiliza para almacenar la cantidad de bytes leídos en cada operación de lectura.
    ssize_t es el tipo de dato apropiado para almacenar este valor
    Ahora, podrías haber usado int en lugar de ssize_t para bytes si solo estás trabajando con valores no 
    negativos (como en tu caso donde el número de bytes nunca será negativo). Sin embargo, usar ssize_t es más 
    preciso y es la práctica común para funciones que devuelven el número de bytes leídos o escritos.

    Si estás seguro de que siempre trabajarás con archivos o pipes pequeños y no te enfrentarás a problemas de tamaño, 
    podrías optar por int. Pero en general, es buena práctica utilizar ssize_t con funciones como read y write..*/

    close(fd[WRITE]);

    printf("soy el proceso padre \n");

    while ((bytes = read(fd[READ], buffer, sizeof(buffer) - 1)) > 0)
    {
      buffer[bytes] = '\0';
      printf("%s", buffer);
    }

    close(fd[READ]);

    wait(NULL);
  }

  return 0;
}