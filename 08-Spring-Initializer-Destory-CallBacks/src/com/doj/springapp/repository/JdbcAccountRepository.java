/**
 * 
 */
package com.doj.springapp.repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.doj.springapp.model.Account;

/**
 * @author Dinesh.Rajput
 *
 */
//@Repository
//@Scope("prototype")
public class JdbcAccountRepository implements AccountRepository, InitializingBean,DisposableBean, BeanNameAware{
	
	@Override
	public Account findAccountById(Long id){
		return new Account(id);
	}
	
	@PostConstruct//Done by JSR 250
	void populateCache(){
		//TODO =Making network connection
		System.out.println("Creating cache for application");
	}
	
	void initCache(){
		//TODO =Making network connection
		System.out.println("Init cache for application");
	}
	
	@PreDestroy//Done by JSR 250
	void cleanUp(){
		//TODO =release network connection
		System.out.println("release cache date from application");
	}

	void cleanCache(){
		//TODO =release network connection
		System.out.println("cleanCache is called, release cache date from application");
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

	@Override
	public void setBeanName(String name) {
		System.out.println("Bean Name Aware is called "+name);
	}
}
