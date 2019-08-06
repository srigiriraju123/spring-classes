/**
 * 
 */
package com.doj.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.doj.app.repository.AccountRepositoryFactoryBean;

/**
 * @author Dinesh.Rajput
 * @Website www.dineshonjava.com
 */
@Configuration
@ComponentScan(basePackages={"com.doj.app.service"})
public class AppConfig {
	
	/*@Bean  ///ar
	public IAccountRepository accountRepository(){
		return new AccountRepository();
	}*/
	
	@Bean //ar
	public AccountRepositoryFactoryBean accountRepository(){
		return new AccountRepositoryFactoryBean();
	}
}
