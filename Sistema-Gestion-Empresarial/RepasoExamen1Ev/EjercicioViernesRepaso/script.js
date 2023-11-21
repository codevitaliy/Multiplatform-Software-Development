function contar() {
  let parrafos = document.getElementsByTagName("p");
  console.log(parrafos.length);
  let enlaces = document.getElementsByTagName("a");
  alert(enlaces.length);

  let mostrarCuartoEnlace = enlaces[3].href;
  let enlace = document.getElementById("enlace");
  enlace.innerHTML = mostrarCuartoEnlace;
  enlace.appendChild(mostrarCuartoEnlace);
  

}

let btnContar = document.getElementById("contar");

btnContar.addEventListener("click", () => {

  contar();

});

function mostrarJson() {
  
}
