#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main() {
    int num_hijos = 3;

    for (int i = 1; i <= num_hijos; i++) {
        pid_t child_pid = fork();

        if (child_pid == 0) {
            // Código del hijo
            printf("Soy el hijo %d (PID: %d, PPID: %d)\n", i, getpid(), getppid());
            exit(0);
        } else if (child_pid < 0) {
            perror("Error al crear el hijo");
            exit(EXIT_FAILURE);
        }
    }

    // Código del padre
    for (int i = 0; i < num_hijos; i++) {
        wait(NULL); // Esperar a que todos los hijos terminen
    }

    printf("Proceso padre (PID: %d) esperando a que todos los hijos terminen\n", getpid());

    return 0;
}
