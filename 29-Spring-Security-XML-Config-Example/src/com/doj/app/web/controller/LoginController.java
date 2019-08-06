/**
 * 
 */
package com.doj.app.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Dinesh.Rajput
 *
 */
@Controller
public class LoginController {
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() {
		return "login" ;
	}
	
	@RequestMapping(value="/login", method= RequestMethod.POST)
	public String doLogin() {
		return "home" ;
	}
}
