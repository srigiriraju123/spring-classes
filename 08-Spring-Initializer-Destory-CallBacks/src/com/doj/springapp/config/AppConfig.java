/**
 * 
 */
package com.doj.springapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Dinesh.Rajput
 *
 */
@Configuration
@ComponentScan(basePackages={"com.doj.springapp.repository", "com.doj.springapp.service", "com.doj.springapp.bfpp", "com.doj.springapp.bpp"})//implicity bean creation
public class AppConfig {
	/*@Bean(initMethod="initCache", destroyMethod="cleanCache")
	public AccountRepository accountRepository(){
		return new JdbcAccountRepository();
	}*/
	
}
