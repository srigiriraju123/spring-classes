/**
 * 
 */
package com.doj.springapp.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author Dinesh.Rajput
 *
 */
@Service
@Lazy
public class AccountService implements BeanNameAware, ApplicationContextAware, BeanFactoryAware{
	
	ApplicationContext applicationContext;
	
	@Override
	public void setBeanName(String beanName) {
		System.out.println("Calling Bean Name Aware "+beanName);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	public void transferFromAccount(){
		TransferService transferService = applicationContext.getBean(TransferService.class);
		transferService.transfer(200l, 1l, 2l);
	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		
	}
}
