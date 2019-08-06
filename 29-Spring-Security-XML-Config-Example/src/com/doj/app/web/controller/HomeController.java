/**
 * 
 */
package com.doj.app.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Dinesh.Rajput
 *
 */
@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home(){
		return "home";
	}
	@RequestMapping("/city")
	public String city(){
		return "city";
	}
	
	
}
