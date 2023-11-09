#include <stdio.h>
#include <unistd.h>

int main() {
    printf("Antes de exec\n");

    // Reemplazar la imagen del proceso actual con el comando "ls"
    execl("/bin/ls", "ls", "-l", NULL);

    // Esta línea solo se alcanzará si execl falla
    perror("exec");
    return 1;
}
