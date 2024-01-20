#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>

int main() {
    // Abrir un archivo para escritura
    int file = open("output.txt", O_WRONLY | O_CREAT | O_TRUNC, 0644);

    if (file < 0) {
        perror("open");
        return 1;
    }

    /** O_WRONLY: Abre el archivo en modo de solo escritura.
        O_CREAT: Crea el archivo si no existe.
        O_TRUNC: Trunca el archivo a longitud cero (borra su contenido) si ya existe.

    La parte 0644 se refiere a los permisos del archivo. En este caso, se establecen permisos para que el propietario 
    tenga permisos de lectura y escritura, mientras que los demás (grupo y otros) 
    solo tienen permisos de lectura. Esto se especifica en formato octal. */

    // Redirigir la salida estándar al archivo
    dup2(file, STDOUT_FILENO);  // STDOUT_FILENO es una constante que representa la salida estándar

    // Ahora, cualquier cosa que escribamos usando printf irá al archivo "output.txt"
    printf("¡Hola, mundo!");

    // Cerrar el archivo
    close(file);

    return 0;
}