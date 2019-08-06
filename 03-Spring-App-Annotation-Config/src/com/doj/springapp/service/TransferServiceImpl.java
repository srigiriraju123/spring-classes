/**
 * 
 */
package com.doj.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.doj.springapp.model.Account;
import com.doj.springapp.repository.AccountRepository;

/**
 * @author Dinesh.Rajput
 *
 */
//4.2 or below
//4.3 or above
@Service
//@Lazy
//@Primary
public class TransferServiceImpl implements TransferService{
	
	//@Resource(name="jdab") //As of 2.5 JSR250
	//@Qualifier("ar")
	@Autowired(required=false)
	AccountRepository accountRepository;
	
	@Autowired
	public TransferServiceImpl(/*@Qualifier("b")*/ AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}
	
	public TransferServiceImpl(AccountRepository accountRepository, int  i) {
		super();
		this.accountRepository = accountRepository;
	}
	
	
	@Override
	public void transfer(Long amount, Long a, Long b){
		Account accountA = accountRepository.findAccountById(a);
		Account accountB = accountRepository.findAccountById(b);
		System.out.println("Amount has been transfered from "+accountA +" to "+accountB);
	}
	
	@Autowired
	public void abc(/*@Qualifier("b")*/ AccountRepository accountRepository){
		this.accountRepository = accountRepository;
	}
}
