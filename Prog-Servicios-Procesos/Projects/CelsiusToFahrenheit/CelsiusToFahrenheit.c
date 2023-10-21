#include <stdlib.h>
#include <stdio.h>


void imprimirTabla(int inicio, int fin, int paso) {

  for(int celsius = inicio; celsius <= fin; celsius += paso) {

    int fahrenheit = (celsius * 9 / 5) + 32;

    printf("%d\t%d\n", celsius, fahrenheit);

  }
}

int main () {


    //Posible solucion 1

   /* int celsius, fahrenheit, formulaResultado;

   printf("Introduce la tempratura en celsius \n");

   scanf("%d", &celsius);

   fahrenheit = (celsius * 9/5) + 32;

   printf("Celsius: %d / Fahrenheit %d \n", celsius, fahrenheit);

   return 0; */

  /*  //Posible solucion 2

   char myStringCelsius[5];
   double celsius, fahrenheit;

   printf("Ingresa una linea de texto: \n");

   if(fgets(myStringCelsius, sizeof(myStringCelsius), stdin) != NULL) {
    
    celsius = atof(myStringCelsius);

   }else {
    
    printf("Ha ocurrido un error");

   }

   fahrenheit = (celsius * 9/5) + 32;

   // lf para double, f para float, d para enteros 

   printf("Celsius: %.2lf / Fahrenheit %.2lf \n", celsius, fahrenheit); */

    int inicio = 0;
    int final = 100;
    int paso = 10;

    imprimirTabla(inicio,final,paso);

    return 0;
   
}




