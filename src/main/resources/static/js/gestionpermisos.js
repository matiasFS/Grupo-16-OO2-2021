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
let allForms = document.getElementsByClassName("formAction");
let advertencias = document.getElementsByClassName("advertencia");
let cantidadDias = document.getElementById("cantidadDias");
let inputDocumentoPermiso = document.getElementsByClassName("inputDocumento");
let inputNombre = document.getElementsByClassName("inputNombre");
let inputDominio = document.getElementsByClassName("inputDominio");



const expresiones = {
	nombre: /^[a-zA-ZÀ-ÿ\s]{1,40}$/, // Letras y espacios, pueden llevar acentos.
	documento: /^\d{7,8}$/, // 8 numeros.
	dominio: /^[a-zA-Z0-9]{6,7}$/, // Letras, numeros, guion y guion_bajo
}






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

navPermisos.addEventListener("click", function(e){
	
	if((e.target).className  == "btnNavPermiso"){
		
		for(let i = 0; i< 4; i++){
			btnNavsPermisos[i].classList.remove("active");
			
		}
		(e.target).classList.add("active");
	
	}
	
	
});

function removerCamposIncorrectos(){
let camposIncorrectos = document.getElementsByClassName("formularioIncorrecto");
	if(camposIncorrectos.length > 0){
		for(i = 0; i < camposIncorrectos.length; i++){
			camposIncorrectos[i].classList.remove("formularioIncorrecto");
		}
	
	}

}
// NAVEGACION MENU LATERAL
// NAVEGACION MENU LATERAL
// NAVEGACION MENU LATERAL
// NAVEGACION MENU LATERAL
function instrucciones(){
	removerCamposIncorrectos()
	for(let i = 0; i<4; i++){
		allForms[i].reset()
		forms[i].classList.remove("active");
	}
	forms[0].classList.add("active");
}

function formPersona(){
	removerCamposIncorrectos()
	for(let i = 0; i<4; i++){
	allForms[i].reset()
		forms[i].classList.remove("active");
	}
	forms[1].classList.add("active");
}

function formRodado(){
	removerCamposIncorrectos()
	for(let i = 0; i<4; i++){
	allForms[i].reset()
		forms[i].classList.remove("active");
	}
	forms[2].classList.add("active");
}

function formPermiso(){
	removerCamposIncorrectos()
	for(let i = 0; i<4; i++){
	allForms[i].reset()
		forms[i].classList.remove("active");
	}
	forms[3].classList.add("active");

}

// NAVEGACION TIPOS DE PERMISOS
// NAVEGACION TIPOS DE PERMISOS
// NAVEGACION TIPOS DE PERMISOS
// NAVEGACION TIPOS DE PERMISOS
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



//VALIDACIONES DE CAMPOS
//VALIDACIONES DE CAMPOS
//VALIDACIONES DE CAMPOS
//VALIDACIONES DE CAMPOS

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

	

for(let  i = 0; i< allForms.length; i++){
	allForms[i].addEventListener("submit", function(e){
			e.preventDefault();
			if(document.getElementsByClassName("formularioIncorrecto").length === 0){
				for(let  j = 0; j< allForms.length; j++){
				advertencias[j].classList.remove("show");
				}
				e.target.submit();
				
			}else{
				if(e.target.classList.contains("persona")){
					advertencias[0].classList.add("show");
				}
				if(e.target.classList.contains("rodado")){
				
					advertencias[1].classList.add("show");
				}
				if(e.target.classList.contains("diario")){
				
					advertencias[2].classList.add("show");
				}
				if(e.target.classList.contains("periodo")){
				
					advertencias[3].classList.add("show");
			}
			}
			
		})		
}






