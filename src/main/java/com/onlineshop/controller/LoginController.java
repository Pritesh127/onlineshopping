package com.onlineshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.onlineshop.entity.Login;
import com.onlineshop.entity.User;
import com.onlineshop.repository.UserRepository;
import com.onlineshop.service.UserService;


@Controller
public class LoginController {

//	@Autowired
//	private UserRepository userRepository;
//	
	@Autowired
	private UserService userService;
	
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

	@PostMapping("/varify")
	public String postlogin(@ModelAttribute("login") Login login) {
		System.out.println(login);
		System.out.println("-------------------------*****************");
		List<User> userObject = userService.getAllUsers();
		for(User user:userObject) {
			if(    (user.getUserEmail().equals(login.getUsername())  &&   
					
					(user.getUserPassword().equals(login.getPassword()))
					
					))
			{
				return "redirect:/landingpage";
			}
				
		}
		return "redirect:/login";
	}

}
