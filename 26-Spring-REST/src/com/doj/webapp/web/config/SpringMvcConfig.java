/**
 * 
 */
package com.doj.webapp.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Dinesh.Rajput
 *
 */
@Configuration
@ComponentScan(basePackages = {"com.doj.webapp.web.controller"})
@EnableWebMvc
public class SpringMvcConfig extends WebMvcConfigurerAdapter{
	
}
