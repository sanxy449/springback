package com.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/showLoginPage")
	public String showMyLoginPage() {
		System.out.println("hello");
		return "login-page";
	}
	
	@GetMapping("/accessDenied")
	public String showAccessDenied() {
		return "access-denied";
		
	}
	
}
