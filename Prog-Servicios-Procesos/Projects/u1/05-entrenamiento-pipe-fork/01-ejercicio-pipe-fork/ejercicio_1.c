#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <time.h>

#define READ 0
#define WRITE 1
#define MAX_RANDOM 100
#define MAX_NUMBERS 3
#define NUM_ONE 1
#define BUFFER_LENGTH 100

int main() {
    srand(time(NULL)); 

    int pipe_fd[2];

    if (pipe(pipe_fd) == -1) {
        perror("Error creating pipe");
        exit(EXIT_FAILURE);
    }

    pid_t pid;

    if ((pid = fork()) == -1) {
        perror("Error creating fork");
        exit(EXIT_FAILURE);
    }

    if (pid == 0) {
        close(pipe_fd[WRITE]);

        int num1, num2, num3;
        int receivedArray[MAX_NUMBERS];

        if (read(pipe_fd[READ], &receivedArray, sizeof(receivedArray)) == -1) {
            perror("Error reading from pipe");
            exit(EXIT_FAILURE);
        }

        close(pipe_fd[READ]);

        num1 = receivedArray[0];
        num2 = receivedArray[1];
        num3 = receivedArray[2];

        // Ordenar de menor a mayor (método de selección)
        if (num1 > num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        if (num2 > num3) {
            int temp = num2;
            num2 = num3;
            num3 = temp;
        }
        if (num1 > num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        FILE *archivo = fopen("archivo.txt", "w");

        if (archivo == NULL) {
            perror("Error opening file");
            exit(EXIT_FAILURE);
        }

        fprintf(archivo, "Número 1: %d\nNúmero 2: %d\nNúmero 3: %d\n", num1, num2, num3);

        fclose(archivo);
    } else {
        close(pipe_fd[READ]);

        int numbersArray[MAX_NUMBERS];

        for (size_t i = 0; i < MAX_NUMBERS; i++) {
            numbersArray[i] = rand() % MAX_RANDOM + NUM_ONE;
        }

        if (write(pipe_fd[WRITE], &numbersArray, sizeof(numbersArray)) == -1) {
            perror("Error writing to pipe");
            exit(EXIT_FAILURE);
        }

        close(pipe_fd[WRITE]);

        wait(NULL);
    }

    return 0;
}
