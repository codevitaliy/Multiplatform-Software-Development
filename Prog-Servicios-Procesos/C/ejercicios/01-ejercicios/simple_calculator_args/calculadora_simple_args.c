#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(int argc,char *argv[]) {

  if (argc != 4) {
    printf("Please enter the operation, and two numbers");
    return 1;
  }

  char *operand = argv[1];
  double num1 = atof(argv[2]);
  double num2 = atof(argv[3]);
  double result;

  if(strcmp(operand, "addition") == 0) {
    result = num1 + num2;
  }

  printf("Result: %.2f\n", result);
      
  return 0;
}

