#include <stdio.h>

#define BUFFER_LENGTH 100

int main() {
    FILE *archivo;  // Declarar un puntero a la estructura FILE

    // Intentar abrir el archivo en modo de añadir ("a+")
    //Puedes abrir archivos en modo lectura ("r"), escritura ("w"), apertura para añadir datos ("a")
    archivo = fopen("archivo.txt", "a+");

    // Verificar si el archivo se abrió correctamente
    if (archivo == NULL) {
        perror("No se pudo abrir el archivo");
        return 1;  // Salir con un código de error
    }

    // Leer desde el archivo
    char buffer[BUFFER_LENGTH];

    //Para leer desde un archivo, puedes utilizar las funciones fread() o fgets(). 
    //Para escribir en un archivo, se usa fwrite() o fprintf().
    // Escribir nueva información al final del archivo
    fprintf(archivo, "Goodbye world!\n");

    // ------EN VEZ DE REWIND ABRIR OTRO DE LECTURA---------------------------------------
    // Mover el puntero al principio
    rewind(archivo);
    // Leer desde el principio del archivo
   
    while (fgets(buffer, sizeof(buffer), archivo) != NULL) {
        printf("%s", buffer);
    }

    fclose(archivo);

    

    /** / // Abrir el archivo en modo lectura de texto
    archivo = fopen("datos.txt", "r");

    // Comprobar si se pudo abrir el archivo
    if (archivo == NULL) {
        perror("No se pudo abrir el archivo");
        return 1;
    }

    // Leer y mostrar las líneas de texto desde el archivo
    printf("Leyendo el archivo de texto:\n");
    char linea[BUFFER_SIZE];
    while (fgets(linea, sizeof(linea), archivo) != NULL) {
        printf("%s", linea);
    }

    // Cerrar el archivo
    fclose(archivo);
    */

    return 0;  // Salir sin errores

    
}

