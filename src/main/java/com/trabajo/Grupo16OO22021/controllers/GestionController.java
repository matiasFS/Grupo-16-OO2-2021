package com.trabajo.Grupo16OO22021.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.trabajo.Grupo16OO22021.helpers.ViewRouteHelper;
import com.trabajo.Grupo16OO22021.models.PermisoDiarioModel;
import com.trabajo.Grupo16OO22021.models.PermisoPeriodoModel;
import com.trabajo.Grupo16OO22021.models.PersonaModel;
import com.trabajo.Grupo16OO22021.models.RodadoModel;
import com.trabajo.Grupo16OO22021.repositories.ILugarRepository;
import com.trabajo.Grupo16OO22021.repositories.IPermisoDiarioRepository;
import com.trabajo.Grupo16OO22021.repositories.IPermisoPeriodoRepository;
import com.trabajo.Grupo16OO22021.repositories.IPersonaRepository;
import com.trabajo.Grupo16OO22021.repositories.IRodadoRepository;
import com.trabajo.Grupo16OO22021.services.implementation.PermisoService;
import com.trabajo.Grupo16OO22021.services.implementation.PersonaService;
import com.trabajo.Grupo16OO22021.services.implementation.RodadoService;

@Controller
public class GestionController {
	
	@Autowired
	@Qualifier("personaService")
	private PersonaService personaService;

	@Autowired
	@Qualifier("rodadoService")
	private RodadoService rodadoService;

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

	@Autowired
	@Qualifier("rodadoRepository")
	private IRodadoRepository rodadoRepository;

	@Autowired
	@Qualifier("lugarRepository")
	private ILugarRepository lugarRepository;

	@GetMapping("/gestion")
	public String gestion() {
		return ViewRouteHelper.GESTION;
	}

	@GetMapping("/createperson")
	public ModelAndView cargarPersonas() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERSONA_NEW);
		mAV.addObject("persona", new PersonaModel());
		return mAV;
	}

	@GetMapping("/createrodado")
	public ModelAndView cargarRodados() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.RODADO);
		mAV.addObject("rodado", new RodadoModel());
		return mAV;
	}

	@PostMapping("/newrodado")
	public RedirectView cargarrodados(RodadoModel rodadoModel) {
		rodadoService.insertOrUpdate(rodadoModel);
		return new RedirectView(ViewRouteHelper.GESTION_ROOT);
	}

	@GetMapping("/createpermisoperiodo")
	public ModelAndView cargarPermiso(Model model) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERMISO);
		mAV.addObject("permiso", new PermisoPeriodoModel()); // MODIFICAR
		model.addAttribute("personas", personaRepository.findAll());
		model.addAttribute("rodados", rodadoRepository.findAll());

		return mAV;
	}

	@PostMapping("/newpermiso")
	public RedirectView cargarpermiso(PermisoPeriodoModel permisoPeriodoModel) {
		permisoService.insertOrUpdate(permisoPeriodoModel);
		return new RedirectView(ViewRouteHelper.GESTION_ROOT);
	}

	@GetMapping("/createpermisodiario")
	public ModelAndView cargarPermisoDiario(Model model) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERMISO_DIARIO);
		mAV.addObject("permiso", new PermisoDiarioModel()); // MODIFICAR
		model.addAttribute("personas", personaRepository.findAll());
		model.addAttribute("lugares", lugarRepository.findAll());

		return mAV;
	}

	@PostMapping("/newpermisodiario")
	public RedirectView cargarpermisoDiario(PermisoDiarioModel permisoDiarioModel) {
		permisoService.insertOrUpdate(permisoDiarioModel);
		return new RedirectView(ViewRouteHelper.GESTION_ROOT);
	}
}
