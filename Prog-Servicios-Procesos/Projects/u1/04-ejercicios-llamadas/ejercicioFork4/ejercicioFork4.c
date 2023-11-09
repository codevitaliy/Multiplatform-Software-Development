#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {
    int num_hijos = 3;

    for (int i = 1; i <= num_hijos; i++) {
        pid_t pid = fork();

        if (pid == -1) {
            perror("Error al crear al hijo");
            return 1;
        }

        if (pid == 0) {
            // Esto se ejecuta en el proceso hijo
            switch (i) {
                case 1:
                    // Código para el primer hijo
                    execlp("ls", "ls", "/", NULL);
                    perror("Error en exec");
                    exit(1);
                case 2:
                    // Código para el segundo hijo
                    {
                        FILE *archivo = fopen("salida.txt", "w");
                        if (archivo == NULL) {
                            perror("Error abriendo archivo");
                            exit(1);
                        }
                        fprintf(archivo, "Hola mundo\n");
                        fclose(archivo);
                    }
                    exit(0); // Importante: el hijo debe salir después de realizar su tarea
                case 3:
                    // Código para el tercer hijo
                    printf("Soy el hijo %d (PID: %d)\n", i, getpid());
                    exit(0);
                default:
                    // Este caso no debería ocurrir
                    fprintf(stderr, "Número de hijo no válido: %d\n", i);
                    exit(1);
            }
        } else {
            // Esto se ejecuta en el proceso padre
            wait(NULL); // Esperar a que el hijo termine
        }
    }

    // Esto se ejecuta solo en el proceso padre
    printf("Soy el proceso padre (PID: %d)\n", getpid());

    return 0;
}
