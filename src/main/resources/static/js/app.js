/**
 * 
 */

let tablePersons = document.getElementById("table-persons");
let tableProfiles = document.getElementById("table-profiles");
let btnPersons = document.getElementById("btnPestañaPersons");
let btnProfiles = document.getElementById("btnPestañaProfiles");



function pestañaPersons(){
	tablePersons.classList.remove("noshow");
	tableProfiles.classList.remove("active");
		btnPersons.classList.remove("nocolor");
	btnProfiles.classList.remove("color");
}
function pestañaProfiles(){
	btnProfiles.classList.add("color");
	btnPersons.classList.add("nocolor");
	tableProfiles.classList.add("active");
	tablePersons.classList.add("noshow");
}