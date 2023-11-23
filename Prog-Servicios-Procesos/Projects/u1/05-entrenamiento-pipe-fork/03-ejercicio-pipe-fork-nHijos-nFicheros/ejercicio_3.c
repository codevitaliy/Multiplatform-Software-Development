#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <time.h>

int main() {
    printf("Introduce un número: ");

    int child_num, result;
    
    result = scanf("%d", &child_num);

    while (result != 1 || child_num <= 0) {
        if (result != 1) {
            printf("Ha introducido un dato no correcto. Ingrese un número: ");
        } else {
            printf("Ha introducido un número menor o igual a 0. Ingrese un número mayor a 0: ");
        }

        // Limpiar el búfer de entrada en caso de un error
        while (getchar() != '\n');

        // Intentar leer un número entero nuevamente
        result = scanf("%d", &child_num);
    }

    printf("Has ingresado un número correcto: %d\n", child_num);

    pid_t pid;

    int i, status;
    int num_fichero = 1;

    for(i = 0; i < child_num ; i++) {

      pid = fork();

      if (pid == 0) {

        //codigo hijos

        char file_name[100];

        sprintf(file_name, "archivo%d.txt", num_fichero);


        FILE *file = fopen(file_name, "w");

        exit(i + 1);

      }

    }

    return 0;
}
