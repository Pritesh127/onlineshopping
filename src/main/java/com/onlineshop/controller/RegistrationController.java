package com.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.onlineshop.entity.User;
import com.onlineshop.service.UserService;

@Controller
public class RegistrationController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/registration")
	public String registration1(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "registrationPageTemplates/registration";
	}
	
	@PostMapping("/registration")
	public String registration(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		System.out.println("*****************************");
		System.out.println(user);
		System.out.println("****************************");
		return "loginTemplates/login";
	}
	

}
