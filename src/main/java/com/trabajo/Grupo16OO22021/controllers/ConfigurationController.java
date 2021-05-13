package com.trabajo.Grupo16OO22021.controllers;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.trabajo.Grupo16OO22021.helpers.ViewRouteHelper;
import com.trabajo.Grupo16OO22021.models.*;

import com.trabajo.Grupo16OO22021.repositories.*;
import com.trabajo.Grupo16OO22021.services.*;

@Controller
@RequestMapping("/manage")
public class ConfigurationController {

	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	@Autowired
	private IRoleRepository roleRepository;
	
	@Autowired
	@Qualifier("roleService")
	private IRoleService roleService;
	
	@GetMapping("")
	public ModelAndView configuracion(Model model) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.MANAGE);
		mAV.addObject("users", userService.getAll());
		model.addAttribute("roles",roleRepository.findAll());

		return mAV;
	}
	
	
	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("user") UserModel userModel) {
		userService.insertOrUpdate(userModel);
		return new RedirectView(ViewRouteHelper.MANAGE_ROOT);
	}	
	
	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("user") UserModel userModel) {
		userService.insertOrUpdate(userModel);
		return new RedirectView(ViewRouteHelper.MANAGE_ROOT);
	}
	
	@PostMapping("/newprofile")
	public RedirectView newProfile(@ModelAttribute("role") UserRoleModel userRoleModel) {
		roleService.insertOrUpdate(userRoleModel);
		return new RedirectView(ViewRouteHelper.MANAGE_ROOT);
	}
	
	@PostMapping("/updateprofile")
	public RedirectView updateProfile(@ModelAttribute("role") UserRoleModel userRoleModel) {
		roleService.insertOrUpdate(userRoleModel);
		return new RedirectView(ViewRouteHelper.MANAGE_ROOT);
	}
	
	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int id) {
		userService.remove(id);
		return new RedirectView(ViewRouteHelper.MANAGE_ROOT);
	}
	@PostMapping("/deleteprofile/{id}")
	public RedirectView deleteprofile(@PathVariable("id") int id) {
		roleService.remove(id);
		return new RedirectView(ViewRouteHelper.MANAGE_ROOT);
	}
	
}