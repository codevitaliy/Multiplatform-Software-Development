#include <stdlib.h>
#include <ctype.h>
#include <stdio.h> //Para poder usar la funcion toupper

int esVocal(char cadena[50])
{

  int numeroVocales = 0;

  for (int i = 0; cadena[i] != '\0'; i++)
  {

    char letra = toupper(cadena[i]);

    if (letra == 'A' || letra == 'E' || letra == 'I' || letra == 'O' || letra == 'U')
    {
      numeroVocales++;
    }
  }

  return numeroVocales;
}

int main()
{

  char cadenaString[50];
  int numeroVocales;

  printf("Introduce una cadenza para contar sus vocales\n");

  scanf("%s", cadenaString);

  numeroVocales = esVocal(cadenaString);

  printf("Número de vocales: %d\n", numeroVocales);

  return 0;
}