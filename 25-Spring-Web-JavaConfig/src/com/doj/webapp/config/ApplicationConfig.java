/**
 * 
 */
package com.doj.webapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Dinesh.Rajput
 *
 */
@ComponentScan(basePackages={"com.doj.webapp.service"})//implicity bean creation
@Import({InfrastructureConfig.class})
@EnableJpaRepositories(("com.doj.webapp.repository"))
public class ApplicationConfig {

}
