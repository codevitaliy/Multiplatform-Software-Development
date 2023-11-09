#include <stdlib.h>
#include <stdio.h> 

#define ARRAY_SIZE 5

int main() {

int arrayNotas[ARRAY_SIZE];
int media = 0, notaMaxima = 0, notaMinima = 10;

printf("Introduce notas de 5 examenes para saber media, nota minima y maxima\n");

for(int i = 0; i < ARRAY_SIZE; i++) {

  scanf("%d", &arrayNotas[i]);

}

for(int i = 0; i < ARRAY_SIZE; i++) {

  media += arrayNotas[i];

}

media /= ARRAY_SIZE;

for(int i = 0; i < ARRAY_SIZE; i++) {

  if(arrayNotas[i] > notaMaxima) {

    notaMaxima = arrayNotas[i];
  }

}

for(int i = 0; i < ARRAY_SIZE; i++) {

  if(arrayNotas[i] < notaMinima) {

    notaMinima = arrayNotas[i];
  }

}

printf("Nota media: %d, Nota maxima: %d, Nota minima: %d", media, notaMaxima, notaMinima);

return 0;


}