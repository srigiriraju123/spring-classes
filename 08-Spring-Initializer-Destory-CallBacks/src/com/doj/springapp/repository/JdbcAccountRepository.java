/**
 * 
 */
package com.doj.springapp.repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.doj.springapp.model.Account;

/**
 * @author Dinesh.Rajput
 *
 */
//@Repository
public class JdbcAccountRepository implements AccountRepository, InitializingBean,DisposableBean{
	
	@Override
	public Account findAccountById(Long id){
		return new Account(id);
	}
	
	@PostConstruct//Done by JSR 250
	void populateCache(){
		//TODO =Making network connection
		System.out.println("Creating cache for application");
	}
	
	@PreDestroy//Done by JSR 250
	void cleanUp(){
		//TODO =release network connection
		System.out.println("release cache date from application");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Creating cache for application by afterPropertiesSet");
	}

	@Override
	public void destroy() throws Exception {
		//TODO =release network connection
		System.out.println("releasse cache date from application by destroy()");
		
	}
}
