#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {
    char *text = "Hello World";

    pid_t pid;

    pid = fork();

    if (pid == 0) {
        FILE *file = fopen("output.txt", "w");

        if (file == NULL) {
            perror("error opening the file");
            return 1;
        }

        fputs(text, file);
        //also can be used fprint(file,"%s",text);
        printf("I am the son. I already printed.\n");
        fclose(file);
    } else {
        wait(NULL);
        printf("I am the father. I will wait: %d\n", getpid());
    }

    return 0;
}
