#include <stdio.h>

int main() {
    int numero = 42;  // Creamos una variable 'numero' y le asignamos el valor 42
    int *puntero;     // Creamos un puntero a un entero (int)

    puntero = &numero;  // Asignamos la dirección de 'numero' al puntero

    printf("Valor de numero: %d\n", numero);
    printf("Dirección de numero: %p\n", &numero);
    
    // Usamos el puntero para acceder al valor almacenado en la dirección de memoria
    printf("Valor almacenado en la dirección del puntero: %d\n", *puntero);

    return 0;
}
