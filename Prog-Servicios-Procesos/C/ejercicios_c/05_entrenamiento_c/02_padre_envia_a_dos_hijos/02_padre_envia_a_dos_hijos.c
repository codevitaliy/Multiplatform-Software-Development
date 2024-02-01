#include <stdio.h>     // Entrada/salida estándar
#include <stdlib.h>    // Funciones de la biblioteca estándar
#include <signal.h>    // Manejo de señales
#include <string.h>    // Funciones de manipulación de cadenas
#include <math.h>      // Funciones matemáticas ---- gcc your_program.c -o your_program -lm ----
#include <ctype.h>     // Funciones de caracteres
#include <time.h>      // Funciones relacionadas con el tiempo
#include <unistd.h>    // Llamadas al sistema estándar de Unix
#include <fcntl.h>     // Operaciones de control de archivos
#include <sys/types.h> // Tipos de datos específicos del sistema
#include <sys/stat.h>  // Funciones relacionadas con la información del archivo
#include <errno.h>     // Códigos de error
#include <sys/wait.h>  // Esperar al hijo
#include <sys/types.h> // Para los pid y ppid;

#define READ 0
#define WRITE 1
#define NUM_PROCESOS 2
#define NUM_MAX_RANDS 20


int main(int argc, char *argv[]) {

  int fd_par[2];
  int fd_impar[2];

  if (pipe(fd_par) == -1 || pipe(fd_impar) == -1) {
    perror("Error creando pipes");
    exit(EXIT_FAILURE);
}

  srand(time(NULL));
  pid_t pid_hijo;
  int hijos_i = 0;
  

  for (hijos_i; hijos_i < NUM_PROCESOS; hijos_i++) {

    pid_hijo = fork();

    if(pid_hijo == 0) {
      break;
    }
  }


  if (hijos_i == NUM_PROCESOS) {

    close(fd_par[READ]);
    close(fd_impar[READ]);

    int random_number = 0;
    
    for(int j = 0; j < NUM_MAX_RANDS; j++){

      random_number = rand();

      if(random_number % 2 == 0) {

        write(fd_par[WRITE], &random_number, sizeof(random_number));

      }else if(random_number % 2 != 0) {

        write(fd_impar[WRITE], &random_number, sizeof(random_number));
      }
    }

    close(fd_impar[WRITE]);
    close(fd_par[WRITE]);
    wait(NULL);
  }

  if (hijos_i == 0) {
    //primer hijo numeros par

    close(fd_par[WRITE]);

    int numero_par = 0;

    while (read(fd_par[READ], &numero_par, sizeof(numero_par)) > 0) {
            // Aquí puedes hacer lo que necesites con el número recibido
            printf("Proceso hijo 1 recibió par : %d\n", numero_par);
        }

    close(fd_par[READ]);

  }

  if (hijos_i == 1) {
    //segundo hijo numeros impares
    
    close(fd_impar[WRITE]);

    int numero_impar = 0;

    while(read(fd_impar[READ], &numero_impar, sizeof(numero_impar)) > 0) {
      printf("Proceso hijo 2 recibio impar: %d\n", numero_impar);
    }

    close(fd_impar[READ]);
  }

  return 0;
}