/**
 * 
 */
package com.doj.SpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Dinesh.Rajput
 *
 */
@Controller
public class HomeController {
	
	/*@RequestMapping(method=RequestMethod.GET, value="/hello")
	String hello (){
		return "hello";
	}*/
	
	@GetMapping("/hello")
	String hello (){
		return "hello";
	}
}
