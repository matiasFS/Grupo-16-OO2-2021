package com.trabajo.Grupo16OO22021.controllers;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lowagie.text.DocumentException;
import com.trabajo.Grupo16OO22021.entities.User;
import com.trabajo.Grupo16OO22021.helpers.ViewRouteHelper;


@Controller
public class UserController {

	@GetMapping("/home")
	public String home(Model model,
						@RequestParam(name="error",required=false) String error,
						@RequestParam(name="logout", required=false) String logout) {
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		return ViewRouteHelper.HOME;
	}

	
	@GetMapping("/logout")
	public String logout(Model model) {
		return ViewRouteHelper.LOGOUT;
	}
	
	@GetMapping("/loginsuccess")
	public String loginCheck() {
		return "redirect:/index";
	}
	
	  
}

