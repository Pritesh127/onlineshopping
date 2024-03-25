package com.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import com.onlineshop.service.UserService;

@Controller
@RequestMapping("users/")
public class UserController {

	@Autowired
	private UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping("/")
	public String listProduct(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		
		return "userTemplates/users";
	}
	
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
		return "redirect:/users/";
	}
	
}
