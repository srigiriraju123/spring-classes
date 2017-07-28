/**
 * 
 */
package com.doj.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Dinesh.Rajput
 *
 */
@Configuration
@ComponentScan(basePackages={"com.doj.webapp"})
public class ApplicationConfig {
	
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
