package com.onlineshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomePageController {
	
	@GetMapping("/")
	public String homePage() {
		return "homePageTemplate/index";
	}
	
	@GetMapping("/landingpage")
	public String landingPage() {
		return "landingPageTemplate/landingpage";
	}
	
	
	

}
