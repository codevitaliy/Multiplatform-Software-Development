#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

#define NUM_HIJOS 3

void funcion_hijo_1() {
    printf("Soy el hijo 1 ejecutando función 1\n");
    // Lógica específica del hijo 1
}

void funcion_hijo_2() {
    printf("Soy el hijo 2 ejecutando función 2\n");
    // Lógica específica del hijo 2
}

void funcion_hijo_3() {
    printf("Soy el hijo 3 ejecutando función 3\n");
    // Lógica específica del hijo 3
}

typedef void (*FuncionHijo)();

void ejecutar_funcion_hijo(int numero_hijo) {
    switch (numero_hijo) {
        case 1:
            funcion_hijo_1();
            break;
        case 2:
            funcion_hijo_2();
            break;
        case 3:
            funcion_hijo_3();
            break;
        default:
            printf("Número de hijo no reconocido\n");
            exit(EXIT_FAILURE);
    }
}

int main() {
    pid_t pid;

    for (int i = 1; i <= NUM_HIJOS; i++) {
        pid = fork();

        if (pid == -1) {
            perror("error fork");
            exit(EXIT_FAILURE);
        }

        if (pid == 0) {
            // Esto es ejecutado en el proceso hijo
            ejecutar_funcion_hijo(i);
            // El hijo debe salir para evitar que continúe en el bucle
            exit(EXIT_SUCCESS);
        }
    }

    // Esto es ejecutado solo en el proceso padre
    for (int i = 0; i < NUM_HIJOS; i++) {
        wait(NULL);
    }

    printf("Soy el padre %d\n", getpid());

    return 0;
}
