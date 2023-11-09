#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>

int main() {
    pid_t child_pid;

    // Create a child process
    child_pid = fork();

    if (child_pid == -1) {
        perror("Error in fork");
        exit(EXIT_FAILURE);
    }

    // Check if it's the parent or child process
    if (child_pid == 0) {
        // Child process
        printf("Child process (PID: %d)\n", getpid());
    } else {
        // Parent process
        printf("Parent process (PID: %d)\n", getpid());
    }

    return 0;
}
