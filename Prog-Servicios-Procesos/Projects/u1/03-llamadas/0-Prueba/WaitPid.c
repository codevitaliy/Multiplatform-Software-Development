#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

int main() {
    pid_t pid, child_pid;
    int status;

    // Crear un proceso hijo
    pid = fork();

    if (pid < 0) {
        perror("Error al crear el proceso hijo");
        exit(EXIT_FAILURE);
    }

    if (pid == 0) {
        // Este es el código del proceso hijo
        printf("Proceso hijo (PID: %d)\n", getpid());
        sleep(2); // Simular trabajo en el proceso hijo
        exit(EXIT_SUCCESS); // Salir del proceso hijo
    } else {
        // Este es el código del proceso padre

        // Esperar a que el proceso hijo termine utilizando wait()
        child_pid = wait(&status);

        if (child_pid > 0) {
            if (WIFEXITED(status)) {
                printf("Proceso hijo (PID: %d) ha terminado con estado %d\n", child_pid, WEXITSTATUS(status));
            } else {
                printf("Proceso hijo (PID: %d) ha terminado de forma anormal\n", child_pid);
            }
        } else {
            perror("Error al esperar al proceso hijo");
            exit(EXIT_FAILURE);
        }
    }

    return 0;
}
