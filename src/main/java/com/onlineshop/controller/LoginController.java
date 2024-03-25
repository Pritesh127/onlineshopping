package com.onlineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.onlineshop.entity.Login;
import com.onlineshop.entity.User;


@Controller
public class LoginController {

	@GetMapping("/login")
	public String login() {
		return "loginTemplates/login";
	}
	
//	@PostMapping("/login")
//	public String postlogin(@ModelAttribute("userdetails") Login userdetails) {
//		System.out.println(userdetails);
//		System.out.println("-------------------------*****************");
//		return "redirect:/landingpage";
//	}
}
