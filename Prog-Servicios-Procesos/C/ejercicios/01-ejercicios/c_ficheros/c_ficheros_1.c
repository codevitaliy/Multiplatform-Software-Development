#include <stdio.h>
#define BUFFER_SIZE 100


int main()
{

  FILE *archivo;

  archivo = fopen("test.txt", "w");

  fprintf(archivo, "Hello world");

  fclose(archivo);

  archivo = fopen("test.txt", "r");

  char linea[BUFFER_SIZE];

  while(fgets(linea, sizeof(linea), archivo) != NULL){
    printf("%s\n", linea);
  }

  fclose(archivo);

  return 0;
}