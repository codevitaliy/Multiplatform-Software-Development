int main(int argc, char *argv[]) { //Esta es la función principal del programa. argc es el número de argumentos pasados al programa, y 
                                    // argv es un array que contiene esos argumentos.
    if (argc != 5) {
        printf("Uso: %s <numero1> <numero2>\n", argv[0]);
        return 1;  // Indicar error

        // if (argc != 3): Verifica si el número de argumentos es diferente de 3 (incluyendo el nombre del programa).
        //  Si es así, imprime un mensaje de uso y retorna un código de error (return 1)

    }

    // atoi: Convierte una cadena de caracteres a un número entero. En este caso, 
    // se utilizan para convertir argv[1] y argv[2] (que son cadenas) en los enteros num1 y num2.

    int num1 = atoi(argv[1]);
    int num2 = atoi(argv[2]);
    int num3 = atoi(argv[3]);
    int num4 = atoi(argv[4]);

    // Imprimir los valores de num1 y num2
    printf("El primer número ingresado es: %d\n", num1);
    printf("El segundo número ingresado es: %d\n", num2);
    printf("El segundo número ingresado es: %d\n", num3);
    printf("El segundo número ingresado es: %d\n", num4);

    return 0;  // Indicar éxito
}
