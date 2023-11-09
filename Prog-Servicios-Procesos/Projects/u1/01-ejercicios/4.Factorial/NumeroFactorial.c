#include <stdlib.h>
#include <stdio.h>

int main()
{

  printf("Enter a number: ");

  int number;
  int auxNumber;

  do
  {

    scanf("%d", &number);

  } while (number < 0);

  if (number == 1 || number == 0)
  {
    printf("Factorial is: 1 \n");

    return 0;
  }

  for (int i = number - 1; i >= 1; i--)
  {
    auxNumber = number * i;
    number = auxNumber;
    
  }

  printf("Factorial is %d \n", number);

  return 0;
}