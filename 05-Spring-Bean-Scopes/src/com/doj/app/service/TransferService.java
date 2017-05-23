/**
 * 
 */
package com.doj.app.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.doj.app.repository.IAccountRepository;

/**
 * @author Manzoor Alam
 *
 */
@Service
@Scope("prototype")
public class TransferService {
	//@Autowired
	IAccountRepository accountRepository;
	
	public TransferService(IAccountRepository accountRepository){
		this.accountRepository = accountRepository;
	}
	
	public void transfer(String accountA, String accountB, Double amount){
		System.out.println("Amount has been tranferred "+accountRepository);
	}
}
