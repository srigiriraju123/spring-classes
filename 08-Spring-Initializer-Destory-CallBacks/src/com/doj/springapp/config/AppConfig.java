/**
 * 
 */
package com.doj.springapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.doj.springapp.repository.AccountRepository;
import com.doj.springapp.repository.JdbcAccountRepository;

/**
 * @author Dinesh.Rajput
 *
 */
@Configuration
@ComponentScan(basePackages={"com.doj.springapp.repository", "com.doj.springapp.service", "com.doj.springapp.bfpp", "com.doj.springapp.bpp"})//implicity bean creation
public class AppConfig {
	
	@Bean(initMethod="initCache", destroyMethod="cleanCache")
	public AccountRepository accountRepository(){
		if(true){
			//Do some logic
		}
		return new JdbcAccountRepository();
	}
	
}
