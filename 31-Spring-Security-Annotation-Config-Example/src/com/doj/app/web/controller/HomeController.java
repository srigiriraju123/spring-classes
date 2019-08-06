package com.doj.app.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Dinesh Rajput
 *
 */
@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home(ModelMap model) {
		model.addAttribute("message", "Learn Spring Security Hello World Example with Annotations");
		model.addAttribute("author", "User of Dinesh on Java");
		return "home";
	}
	
	@GetMapping("/admin")
	public String admin(ModelMap model) {
		model.addAttribute("message", "Create Spring Security Hello World Example with Annotations");
		model.addAttribute("author", "Admin of Dinesh on Java");
		return "admin";
	}
}
