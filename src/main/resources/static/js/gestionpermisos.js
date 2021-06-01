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


function mostrarNotificacion(){
	if(mensajeConfirmacion[0].textContent !== ""){
		mensajeConfirmacion[0].classList.add("active");
	
	}
	
	if(mensajeError[0].textContent !== ""){
		mensajeError[0].classList.add("active");
	}
	

	

}
mostrarNotificacion();

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


