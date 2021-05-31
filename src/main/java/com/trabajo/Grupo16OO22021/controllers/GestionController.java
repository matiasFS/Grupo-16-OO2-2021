package com.trabajo.Grupo16OO22021.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.trabajo.Grupo16OO22021.entities.PermisoDiario;
import com.trabajo.Grupo16OO22021.entities.PermisoPeriodo;
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
import com.trabajo.Grupo16OO22021.services.implementation.RodadoService;

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


	@Autowired
	@Qualifier("rodadoService")
	private RodadoService rodadoService;

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
		if (!personaService.validate(personaModel)) {
			return new RedirectView(ViewRouteHelper.PERSONA_NEW_ROOT);
		} else {
			personaService.insertOrUpdate(personaModel);
			return new RedirectView(ViewRouteHelper.GESTION_PERMISOS);
		}


	}

	@PostMapping("/newrodado")
	public RedirectView cargarrodados(RodadoModel rodadoModel) {
		if (!rodadoService.validate(rodadoModel)) {
			return new RedirectView(ViewRouteHelper.RODADO_NEW_ROOT);
		} else {
			rodadoService.insertOrUpdate(rodadoModel);
			return new RedirectView(ViewRouteHelper.GESTION_PERMISOS);
		}
	}

	@GetMapping("/fecha")
	public ModelAndView getporfecha() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.FECHA);
		LocalDate fechaDesde = null;
		LocalDate fechaHasta = null;

		mAV.addObject("fecha", fechaDesde);
		mAV.addObject("fecha", fechaHasta);

		return mAV;
	}

	@PostMapping("/buscarfecha")
	public ModelAndView getprfecha(String fechaDesde, String fechaHasta, Model model) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.FECHA_MOSTRAR);
		LocalDate fechaDesde1 = LocalDate.parse(fechaDesde);
		LocalDate fechaHasta1 = LocalDate.parse(fechaHasta);

		List<PermisoDiario> permisoDiarioLista = permisoService.getAll1();
		List<PermisoDiario> permisoDiarioLista1 = new ArrayList<PermisoDiario>();

		List<PermisoPeriodo> permisoPeriodoLista = permisoService.getAll();
		List<PermisoPeriodo> permisoPeriodoLista1 = new ArrayList<PermisoPeriodo>();

		for (PermisoDiario permisoDiarioLista2 : permisoDiarioLista) {
			if (permisoDiarioLista2.getFecha().isAfter(fechaDesde1)
					&& permisoDiarioLista2.getFecha().isBefore(fechaHasta1)) {
				permisoDiarioLista1.add(permisoDiarioLista2);
			}
		}
		for (PermisoPeriodo permisoPeriodoLista2 : permisoPeriodoLista) {
			if (permisoPeriodoLista2.getFecha().isAfter(fechaDesde1)
					&& permisoPeriodoLista2.getFecha().isBefore(fechaHasta1)) {
				permisoPeriodoLista1.add(permisoPeriodoLista2);
			}
		}

		mAV.addObject("permisoPeriodo", permisoPeriodoLista1);
		mAV.addObject("permisoDiario", permisoDiarioLista1);

		return mAV;
	}
}
