/**
 * 
 */

let navPermisos = document.getElementById("navPermisos");
let btnNavsPermisos = (document.getElementById("navPermisos").getElementsByTagName("a"));

let forms = document.getElementById("forms").getElementsByTagName("section");


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
