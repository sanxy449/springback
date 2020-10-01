package com.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String showHome() {	
		return "home";
	}
	
	@GetMapping("/leaders")
	public String showBoss() {	
		return "leader-page";
	}
	
	@GetMapping("/systems")
	public String showAdmin() {	
		return "admin-page";
	}
	
}