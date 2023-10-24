#include <stdio.h>
#include <string.h> // sirve para comparar string strcmp(operando, "suma") == != 0)

int main()
{
  int operadorUno = 0, operadorDos = 0, resultado = 0;
  char operando[20]; // Make sure there is enough space for the null terminator

  printf("Ingrese dos operadores y un operando (ejemplo: 5 3 suma): ");
  scanf("%d %d %s", &operadorUno, &operadorDos, operando);

  if (strcmp(operando, "suma") == 0)
  {
    resultado = operadorUno + operadorDos;
  }
  else if (strcmp(operando, "resta") == 0)
  {
    resultado = operadorUno - operadorDos;
  }
  else if (strcmp(operando, "division") == 0)
  {

    if (operadorDos == 0)
    {
      printf("el segundo operador no puede ser cero");
    }
    else
    {
      resultado = operadorUno / operadorDos;
    }
  }
  else if (strcmp(operando, "multiplicacion") == 0)
  {
    resultado = operadorUno * operadorDos;
  }

  printf("El resutlado es: %d", resultado);

  return 0;
}