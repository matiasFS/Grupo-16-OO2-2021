package com.trabajo.Grupo16OO22021.controllers;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.trabajo.Grupo16OO22021.services.implementation.RoleService;

import com.trabajo.Grupo16OO22021.repositories.*;
import com.trabajo.Grupo16OO22021.services.*;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/manage")
public class ConfigurationController {

	@Autowired
	@Qualifier("userService")
	private IUserService userService;
	
	@Autowired
	private IRoleRepository roleRepository;
	
	@Autowired
	@Qualifier("roleService")
	private RoleService roleService;
	
	@GetMapping("")
	public ModelAndView configuracion(Model model) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.MANAGE);
		mAV.addObject("users", userService.getAll());
		model.addAttribute("roles",roleRepository.findAll());

		return mAV;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/createuser")
	public RedirectView create(@ModelAttribute("user") UserModel userModel) {
		if(!userService.validate(userModel)) {
			return new RedirectView(ViewRouteHelper.USER_NEW_ROOT);
		}else {
			userService.insertOrUpdate(userModel);
			return new RedirectView(ViewRouteHelper.MANAGE_ROOT);
		}
		
	}		
	
	@PostMapping("/updateuser{id}")
	public RedirectView update(@PathVariable("id") int id, @ModelAttribute("user") UserModel userModel, Model model) {
		if(!userService.validate(userModel)) {
			ModelAndView mAV = new ModelAndView();
			mAV.addObject("user", userService.findById(id));
			model.addAttribute("roles",roleRepository.findAll());
			return new RedirectView(ViewRouteHelper.USER_UPDATE_ROOT);
		}else {
			userService.insertOrUpdate(userModel);
			return new RedirectView(ViewRouteHelper.MANAGE_ROOT);
		}
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/createprofile")
	public RedirectView newProfile(@ModelAttribute("role") UserRoleModel userRoleModel) {
		if(!roleService.validate(userRoleModel)) {
			return new RedirectView(ViewRouteHelper.PROFILE_NEW_ROOT);
		}else {
			roleService.insertOrUpdate(userRoleModel);
			return new RedirectView(ViewRouteHelper.MANAGE_ROOT);
		}
	}
	
	@PostMapping("/updateprofile{id}")
	public RedirectView updateProfile(@PathVariable("id") int id, @ModelAttribute("role") UserRoleModel userRoleModel) {
		if(!roleService.validate(userRoleModel)) {
			return new RedirectView(ViewRouteHelper.PROFILE_UPDATE_ROOT);
		}else {
			roleService.insertOrUpdate(userRoleModel);
			return new RedirectView(ViewRouteHelper.MANAGE_ROOT);
		}
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int id) {
		userService.remove(id);
		return new RedirectView(ViewRouteHelper.MANAGE_ROOT);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/deleteprofile/{id}")
	public RedirectView deleteprofile(@PathVariable("id") int id) {
		roleService.remove(id);
		return new RedirectView(ViewRouteHelper.MANAGE_ROOT);
	}
	
}