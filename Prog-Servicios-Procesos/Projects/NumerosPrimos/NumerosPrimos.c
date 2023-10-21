#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>


bool esPrimo(int numero){

  if (numero < 2) {
    printf("Numero 1 no es primo");
    return false;
  }


for(int i = 2; i * i <= numero; i++)  {
  if (numero % i == 0) {
    printf("No es numero primo");
    return false;
  }
}

  printf("Numero: %d es primo \n", numero);
  return true;

  }

int main () {

int numero;

printf("Introduce un numero: \n");

scanf("%d", &numero);

esPrimo(numero);

return 0;

}