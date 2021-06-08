/**
 * 
 */



let mensajeError = document.getElementsByClassName("mensajeError");
let mensajeConfirmacion = document.getElementsByClassName("mensajeConfirmacion");
let notification = document.getElementById("notification");

function mostrarNotificacion(){
	if(mensajeConfirmacion[0].textContent !== ""){
		mensajeConfirmacion[0].classList.add("show");
		notification.classList.toggle("active");
	}
	
	if(mensajeError[0].textContent !== ""){
		mensajeError[0].classList.add("show");
		notification.classList.toggle("active");
	}
	
}
mostrarNotificacion();

function cerrarNot(){
	notification.classList.toggle("active");
}
