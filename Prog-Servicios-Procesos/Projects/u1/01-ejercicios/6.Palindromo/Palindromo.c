#include <stdio.h>
#include <stdbool.h>
#include <string.h>

bool esPalindromo(const char frase[]) {
    int longitudFrase = strlen(frase);

    for (int i = 0, j = longitudFrase - 1; i < j; i++, j--) {
        if (frase[i] != frase[j]) {
            return false;
        }
    }

    return true;
}

int main() {
    char frase[50];

    printf("Introduce una frase para verificar si es palindromo\n");
    fgets(frase, sizeof(frase), stdin);

    // Eliminar el carácter de nueva línea al final
    frase[strcspn(frase, "\n")] = '\0';

    if (esPalindromo(frase)) {
        printf("Es palindroma\n");
    } else {
        printf("No es palindroma\n");
    }

    return 0;
}
