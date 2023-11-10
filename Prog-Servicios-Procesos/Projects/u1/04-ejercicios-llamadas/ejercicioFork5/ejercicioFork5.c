#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

#define NUM_SONS 3

int main() {
    pid_t pid;
    int i, status;

    for (i = 0; i < NUM_SONS; i++) {
        pid = fork();

        if (pid == 0) {
            // Código del hijo
            printf("Soy el hijo [%d] con PID [%d] y PPID [%d]\n", i, getpid(), getppid());
            // Salir con un valor específico para el hijo
            exit(i + 1);
        }
    }

    for (i = 0; i < NUM_SONS; i++) {
        // Esperar a que cada hijo termine y recoger su estado
        wait(&status);

        if (WIFEXITED(status)) {
            // Imprimir el valor de retorno del hijo
            printf("El hijo [%d] devolvió %d\n", getpid(),WEXITSTATUS(status));
        }
    }

    printf("Soy el padre con PID [%d]\n", getpid());

    return 0;
}