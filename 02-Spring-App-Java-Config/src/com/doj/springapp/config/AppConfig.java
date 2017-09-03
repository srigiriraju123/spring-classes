/**
 * 
 */
package com.doj.springapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.doj.springapp.repository.AccountRepository;
import com.doj.springapp.repository.JdbcAccountRepository;
import com.doj.springapp.service.TransferService;
import com.doj.springapp.service.TransferServiceImpl;

/**
 * @author Dinesh.Rajput
 *
 */
@Configuration
public class AppConfig {
	//these are bean methods
	@Bean(name={"service","transferService"})
	public TransferService transferServices(){
		return new TransferServiceImpl(accountRepository());
	}
	@Bean	
	//@Profile("dev")
	public AccountRepository accountRepository() {
		return new JdbcAccountRepository();
	}
}
