// Enviar button click event
let myInputObject = document.getElementsByTagName("input");

myInputObject[2].addEventListener("click", () => {
  let nombres = myInputObject[0].value + " " + myInputObject[1].value;
  alert(nombres);
});

// SUMAR button click event
myInputObject[5].addEventListener("click", () => {
  let number1 = parseInt(myInputObject[3].value);
  let number2 = parseInt(myInputObject[4].value);
  
  alert(number1 + number2);
 
});