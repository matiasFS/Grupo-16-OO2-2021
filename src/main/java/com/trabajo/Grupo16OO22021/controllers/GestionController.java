package com.trabajo.Grupo16OO22021.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.trabajo.Grupo16OO22021.helpers.ViewRouteHelper;
import com.trabajo.Grupo16OO22021.models.PermisoDiarioModel;
import com.trabajo.Grupo16OO22021.models.PermisoPeriodoModel;
import com.trabajo.Grupo16OO22021.models.PersonaModel;
import com.trabajo.Grupo16OO22021.models.RodadoModel;

import com.trabajo.Grupo16OO22021.repositories.IPermisoDiarioRepository;
import com.trabajo.Grupo16OO22021.repositories.IPermisoPeriodoRepository;
import com.trabajo.Grupo16OO22021.repositories.IPersonaRepository;

import com.trabajo.Grupo16OO22021.services.implementation.PermisoService;
import com.trabajo.Grupo16OO22021.services.implementation.PersonaService;


@Controller
public class GestionController {
	
	@Autowired
	@Qualifier("personaService")
	private PersonaService personaService;



	@Autowired
	@Qualifier("permisoService")
	private PermisoService permisoService;

	@Autowired
	@Qualifier("personaRepository")
	private IPersonaRepository personaRepository;

	@Autowired
	@Qualifier("permisoPeriodoRepository")
	private IPermisoPeriodoRepository permisoPeriodoRepository;

	@Autowired
	@Qualifier("permisoDiarioRepository")
	private IPermisoDiarioRepository permisoDiarioRepository;



	@GetMapping("/gestion")
	public String gestion() {
		return ViewRouteHelper.GESTION;
	}

	@GetMapping("/gestiondepermisos")
	public ModelAndView gestionPermisos() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.GESTION_PERMISOS);
		mAV.addObject("persona", new PersonaModel());
		return mAV;
	}
	@PostMapping("/crearpersona")
	public RedirectView create(@ModelAttribute("persona") PersonaModel personaModel) {
		System.out.println(personaModel);
		if(!personaService.validate(personaModel)) {
			return new RedirectView(ViewRouteHelper.PERSONA_NEW_ROOT);
		}else {
			personaService.insertOrUpdate(personaModel);
			return new RedirectView(ViewRouteHelper.GESTION_PERMISOS);
		}
		
	}	

	
}
