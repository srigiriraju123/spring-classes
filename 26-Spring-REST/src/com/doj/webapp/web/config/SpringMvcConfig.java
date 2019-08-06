/**
 * 
 */
package com.doj.webapp.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Dinesh.Rajput
 *
 */
@Configuration
@ComponentScan(basePackages = {"com.doj.webapp.web.controller"})
@EnableWebMvc
public class SpringMvcConfig/* extends WebMvcConfigurerAdapter*/{

	/*@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
	}*/
	
}
