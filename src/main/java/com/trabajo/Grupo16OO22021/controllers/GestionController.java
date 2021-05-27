package com.trabajo.Grupo16OO22021.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.trabajo.Grupo16OO22021.helpers.ViewRouteHelper;

@Controller
public class GestionController {
	
	@GetMapping("/gestion")
	public String gestion() {
		return ViewRouteHelper.GESTION;
	}
}
