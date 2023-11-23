let btnDebajo = document.getElementById("debajo");
let listaInputs = document.getElementsByTagName("input");
let lista = document.getElementById("lista");

btnDebajo.addEventListener("click", () => {

  let textInput = listaInputs[0].value;
  let newElementList = document.createElement("li");
  newElementList.innerHTML = textInput;
  lista.appendChild(newElementList);
  
});

let btnArriba = listaInputs[1];

btnArriba.addEventListener("click", () => {

  let textInput = listaInputs[0].value;
  let newElementList = document.createElement("li");
  newElementList.innerHTML = textInput;
  lista.prepend(newElementList);
  

});

