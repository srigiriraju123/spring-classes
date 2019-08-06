/**
 * 
 */
package com.doj.springapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.doj.springapp.repository.AccountRepository;
import com.doj.springapp.repository.JdbcAccountRepository;
import com.doj.springapp.service.TransferService;
import com.doj.springapp.service.TransferServiceImpl;

/**
 * @author Dinesh.Rajput
 * CGLib
 */
@Configuration
public class AppConfig { //AppConfig#CGLIB extends AppConfig{..}
	
	//these are bean methods
	@Bean(name={"transferService"})
	//@Scope("prototype")
	//@Bean
	//@Lazy
	public TransferService transferService(){
		System.out.println("Transfer Service Loading");
		return new TransferServiceImpl(accountRepository());
	}
	
	@Bean
	@Primary
	public TransferService transferServices2(){
		return new TransferServiceImpl(accountRepository());
	}
	
	@Bean
	//@Scope("prototype")
	public AccountRepository accountRepository() {
		System.out.println("Calling accountRepository()");
		return new JdbcAccountRepository();
	}
}
