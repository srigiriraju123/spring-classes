/**
 * 
 */
package com.doj.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Dinesh.Rajput
 *
 */
@Configuration
@ComponentScan(basePackages = {"com.doj.app.service", "com.doj.app.repository"})
@Import(InfrastructureConfig.class)
public class RootConfig {

}
