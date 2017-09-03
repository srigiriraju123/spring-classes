/**
 * 
 */
package com.doj.springapp.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.doj.springapp.model.Account;
import com.doj.springapp.repository.AccountRepository;

/**
 * @author Dinesh.Rajput
 *
 */
@Service
public class TransferServiceImpl implements TransferService, ApplicationContextAware, BeanNameAware{
	
	AccountRepository accountRepository;
	
	ApplicationContext applicationContext;
	
	public TransferServiceImpl(AccountRepository accountRepository) {//as 4.3
		super();
		this.accountRepository = accountRepository;
	}
	
	@Override
	public void transfer(Long amount, Long a, Long b){
		//security//logging//transaction --non functional -not business data
		Account accountA = accountRepository.findAccountById(a);
		Account accountB = accountRepository.findAccountById(b);
		System.out.println("Amount has been transfered from "+accountA +" to "+accountB);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	public void setBeanName(String name) {
		System.out.println(name);
	}
}
