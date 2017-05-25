/**
 * 
 */
package com.doj.springapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Dinesh.Rajput
 *
 */
@Configuration
@ComponentScan(basePackages={"com.doj.springapp.repository", "com.doj.springapp.service"})//implicity bean creation
@Import({InfrastructureConfig.class, SecurityConfig.class})
@EnableJpaRepositories(("com.doj.springapp.repository"))
public class AppConfig {
	
}
