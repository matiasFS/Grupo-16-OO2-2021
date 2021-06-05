/**
 * 
 */

let navPermisos = document.getElementById("navPermisos");
let btnNavsPermisos = (document.getElementById("navPermisos").getElementsByTagName("a"));

let forms = document.getElementById("forms").getElementsByTagName("section");
let navTipoPermiso = document.getElementById("navTipoPermiso");
let formsPeriodoDiario = document.getElementById("formPeriodoDiario").getElementsByTagName("form");
let btnTipoPermiso = document.getElementsByClassName("card btnTipoPermiso");
let mensajeError = document.getElementsByClassName("mensajeError");
let mensajeConfirmacion = document.getElementsByClassName("mensajeConfirmacion");
let notification = document.getElementById("notification");



const expresiones = {
	nombre: /^[a-zA-ZÀ-ÿ\s]{1,40}$/, // Letras y espacios, pueden llevar acentos.
	documento: /^\d{8}$/, // 8 numeros.
	dominio: /^[a-zA-Z0-9]{6,7}$/, // Letras, numeros, guion y guion_bajo
}






function mostrarNotificacion(){
	if(mensajeConfirmacion[0].textContent !== ""){
		mensajeConfirmacion[0].classList.add("active");
		notification.classList.toggle("active");
	}
	
	if(mensajeError[0].textContent !== ""){
		mensajeError[0].classList.add("active");
		notification.classList.toggle("active");
	}
	
}
mostrarNotificacion();

function cerrarNot(){
	notification.classList.toggle("active");
}

navPermisos.addEventListener("click", function(e){
	
	if((e.target).className  == "btnNavPermiso"){
		
		for(let i = 0; i< 4; i++){
			btnNavsPermisos[i].classList.remove("active");
			
		}
		(e.target).classList.add("active");
	
	}
	
	
});

function instrucciones(){
	for(let i = 0; i<4; i++){
		forms[i].classList.remove("active");
	}
	forms[0].classList.add("active");
}

function formPersona(){
	for(let i = 0; i<4; i++){
		forms[i].classList.remove("active");
	}
	forms[1].classList.add("active");
}

function formRodado(){
	for(let i = 0; i<4; i++){
		forms[i].classList.remove("active");
	}
	forms[2].classList.add("active");
}

function formPermiso(){
	for(let i = 0; i<4; i++){
		forms[i].classList.remove("active");
	}
	forms[3].classList.add("active");
}
navTipoPermiso.addEventListener("click",function(e){
	let btns = navTipoPermiso.getElementsByTagName("a");
	for(let i = 0; i<2 ; i++){
	
		btns[i].classList.remove("active");
	}
	(e.target).classList.toggle("active");

})
function formPermisoDiario(){
	
	for(let i = 0; i<2 ; i++){
	
		formsPeriodoDiario[i].classList.remove("active");
		btnTipoPermiso[i].classList.remove("active");
	}
	formsPeriodoDiario[0].classList.toggle("active");
	btnTipoPermiso[0].classList.toggle("active");
}
function formPermisoPeriodo(){
	
	for(let i = 0; i<2 ; i++){
	
		formsPeriodoDiario[i].classList.remove("active");
		btnTipoPermiso[i].classList.remove("active");
	}
	formsPeriodoDiario[1].classList.toggle("active");
		btnTipoPermiso[1].classList.toggle("active");
}



let cantidadDias = document.getElementById("cantidadDias");
let inputDocumentoPermiso = document.getElementsByClassName("inputDocumento");
let inputNombre = document.getElementsByClassName("inputNombre");
let inputDominio = document.getElementsByClassName("inputDominio");
for(let i = 0; i< inputDocumentoPermiso.length ; i++){
	inputDocumentoPermiso[i].addEventListener("keyup",function(e){
		if(!expresiones.documento.test(e.target.value)){
			e.target.classList.add("formularioIncorrecto");
		}
		else{
			e.target.classList.remove("formularioIncorrecto");
		}
	
	})

}

for(let i = 0; i< inputNombre.length ; i++){
	inputNombre[i].addEventListener("keyup",function(e){
		if(!expresiones.nombre.test(e.target.value)){
			e.target.classList.add("formularioIncorrecto");
		}
		else{
			e.target.classList.remove("formularioIncorrecto");
		}
	
	})

}
for(let i = 0; i< inputDominio.length ; i++){
	inputDominio[i].addEventListener("keyup",function(e){
		if(!expresiones.dominio.test(e.target.value)){
			e.target.classList.add("formularioIncorrecto");
		}
		else{
			e.target.classList.remove("formularioIncorrecto");
		}
	
	})

}
cantidadDias.addEventListener("keyup",function(e){
		if(e.target.value === "0"){
			e.target.classList.add("formularioIncorrecto");
		}
		else{
			e.target.classList.remove("formularioIncorrecto");
		}
})






