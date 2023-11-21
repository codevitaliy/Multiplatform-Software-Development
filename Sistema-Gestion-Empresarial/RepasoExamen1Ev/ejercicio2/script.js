let listaInput = document.getElementsByTagName("input");

function validar() {

  if(listaInput[0].value === "" || listaInput[1].value === "") {
    alert("Nombre o Apellidos no introducido");
  }

  if(listaInput[0].value.length < 5 || listaInput[0].value.length > 40) {
    alert("Es inferior a 5 o supera los 40 caracteres");
  }

  if(!listaInput[2].checked && !listaInput[3].checked && !listaInput[4].checked) {
    alert("Tiene que haber seleccionado un color minimo");
  }

}

let btnEnviar = listaInput[5];

btnEnviar.addEventListener("click", () => {
  validar();
});

