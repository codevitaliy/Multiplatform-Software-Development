#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>

int main() {
    char *command = "ls";
    char *arguments[] = {"ls", "/", NULL};

    // Abrir un archivo para escritura
    int file = open("output.txt", O_WRONLY | O_CREAT | O_TRUNC, 0644);

    if (file < 0) {
        perror("open");
        return 1;
    }

    // Redirigir la salida estándar al archivo usando dup2
    dup2(file, STDOUT_FILENO);

	  // 0 (STDIN_FILENO): Entrada estándar (por defecto, el teclado).
    // 1 (STDOUT_FILENO): Salida estándar (por defecto, la pantalla).
    // 2 (STDERR_FILENO): Salida de error estándar (también por defecto, la pantalla).
      
    // Ejecutar el comando ls con sus argumentos
    execvp(command, arguments);

		// Ahora, cuando ejecutas execvp(command, arguments);, el sistema operativo inicia un nuevo programa
		//  (ls en este caso) en el proceso actual. Debido a la redirección que has hecho previamente con dup2, 
		//  el nuevo programa hereda la salida estándar redirigida al archivo en lugar de a la consola.

    close(file);

		return 0;
}
