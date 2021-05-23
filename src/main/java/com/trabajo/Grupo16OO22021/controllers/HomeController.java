package com.trabajo.Grupo16OO22021.controllers;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.lowagie.text.DocumentException;
import com.trabajo.Grupo16OO22021.ProfilePDFExporter;
import com.trabajo.Grupo16OO22021.UserPDFExporter;
import com.trabajo.Grupo16OO22021.helpers.ViewRouteHelper;
import com.trabajo.Grupo16OO22021.models.UserModel;
import com.trabajo.Grupo16OO22021.models.UserRoleModel;

import com.trabajo.Grupo16OO22021.services.IUserService;

import com.trabajo.Grupo16OO22021.repositories.IRoleRepository;
import com.trabajo.Grupo16OO22021.services.implementation.RoleService;
import com.trabajo.Grupo16OO22021.services.implementation.UserService;

@SuppressWarnings("unused")
@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@Autowired
	@Qualifier("roleService")
	private RoleService roleService;

	@Autowired
	private IRoleRepository roleRepository;

	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.INDEX);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		modelAndView.addObject("username", user.getUsername());
		modelAndView.addObject("users", userService.getAll());
		return modelAndView;
	}
	@GetMapping("/admin")
	public ModelAndView adminIndex() {
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.ADMIN_INDEX);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		modelAndView.addObject("username", user.getUsername());
		modelAndView.addObject("users", userService.getAll());
		return modelAndView;
	}

	@GetMapping("/")
	public String redirectToHomeIndex() {
		return ViewRouteHelper.INDEX;
	}

	@PreAuthorize("hasRole('ROLE_AUDITOR')")
	@GetMapping("/users.html")
	public ModelAndView users() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.USERS);
		mAV.addObject("users", userService.getAll());
		return mAV;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/adminUsers.html")
	public ModelAndView Users() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.ADMIN_USERS);
		mAV.addObject("users", userService.getAll());
		return mAV;
	}

	@PreAuthorize("hasRole('ROLE_AUDITOR')")
	@GetMapping("/profiles.html")
	public String profiles(Model model) {
		model.addAttribute("roles", roleRepository.findAll());

		return ViewRouteHelper.PROFILES;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/adminProfiles.html")
	public String adminProfiles(Model model) {
		model.addAttribute("roles", roleRepository.findAll());
		
		return ViewRouteHelper.ADMIN_PROFILES;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/newuser")
	public ModelAndView create(Model model) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.USER_NEW);
		mAV.addObject("user", new UserModel());
		model.addAttribute("roles", roleRepository.findAll());
		mAV.addObject("userList", userService.getAll());
		return mAV;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/newprofile")
	public ModelAndView createProfile() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PROFILE_NEW);
		mAV.addObject("role", new UserRoleModel());
		return mAV;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/updateuser{id}")
	public ModelAndView get(@PathVariable("id") int id, Model model) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.USER_UPDATE);
		mAV.addObject("user", userService.findById(id));
		model.addAttribute("roles", roleRepository.findAll());

		return mAV;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/updateprofile{id}")
	public ModelAndView getprofile(@PathVariable("id") int id, Model model) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PROFILE_UPDATE);
		mAV.addObject("role", roleService.findById(id));
		model.addAttribute("roles", roleRepository.findAll());

		return mAV;
	}

	@PreAuthorize("hasRole('ROLE_AUDITOR')")
	@GetMapping("/users/export/pdf")
	public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new java.util.Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=UserList_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		List<com.trabajo.Grupo16OO22021.entities.User> listUsers = userService.getAll();

		UserPDFExporter exporter = new UserPDFExporter(listUsers);
		exporter.export(response);

	}

	@PreAuthorize("hasRole('ROLE_AUDITOR')")
	@GetMapping("/profiles/export/pdf")
	public void exportToPDFProfile(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new java.util.Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=ProfileList_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		List<com.trabajo.Grupo16OO22021.entities.UserRole> listUserRole = roleService.getAll();

		ProfilePDFExporter exporter = new ProfilePDFExporter(listUserRole);
		exporter.export(response);

	}

}