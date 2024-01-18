#include <stdio.h>

int main()
{

  // FIRST WAY

  int num1, num2, addedNums;

  printf("Enter two numbers to add them: \n");

  scanf("%d %d", &num1, &num2);

  addedNums = num1 + num2;

  printf("The result is: %d \n", addedNums);

  return 0;
  
  //EXAMPLE OF FGETS
  // Buffer to store the input
  char buffer[100]; 

  // Prompt the user for input
  printf("Enter a line of text: ");

  // Use fgets to read a line of text from the keyboard
  fgets(buffer, sizeof(buffer), stdin);

  // Display the entered text
  printf("You entered: %s", buffer);

  return 0;
  

 // SECOND WAY

/*
 char str1[20], str2[20];
 int result;

 printf("Enter 2 numbers: \n");

 fgets(str1, sizeof(str1), stdin);
 fgets(str2,sizeof(str2), stdin);

 int num1 = atoi(str1);
 int num2 = atoi(str2);

result = num1 + num2;

printf("El resultado es de: %d\n",result);

return 0;
*/

}