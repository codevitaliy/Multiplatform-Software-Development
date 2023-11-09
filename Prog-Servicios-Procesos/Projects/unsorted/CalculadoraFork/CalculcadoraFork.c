#include <stdio.h>        // Librería estándar de entrada/salida
#include <stdlib.h>       // Librería estándar de funciones de utilidad
#include <sys/types.h>    // Definiciones de tipos de datos para llamadas al sistema
#include <unistd.h>       // Llamadas al sistema relacionadas con el sistema operativo POSIX
#include <sys/wait.h>     // Funciones de espera para procesos hijos


int imprimirTabla(int numero) {
    for (int i = 1; i <= 10; i++) {
        printf("%d x %d = %d\n", numero, i, numero * i);
    }
    return 0;
}

int main(void) {
    for (int i = 1; i <= 10; i++) {
        pid_t idHijo;
        idHijo = fork();

       if (idHijo == 0) {
            // codigo de hijo
            printf("Hijo %d:\n", i);
            imprimirTabla(i);
            exit(0);
        }else {
            wait(NULL); //
        }
    }
}
