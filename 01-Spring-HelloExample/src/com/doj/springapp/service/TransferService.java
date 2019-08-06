/**
 * 
 */
package com.doj.springapp.service;

import com.doj.springapp.model.Account;
import com.doj.springapp.repository.AccountRepository;

/**
 * @author Dinesh.Rajput
 *
 */
public class TransferService {
	
	AccountRepository accountRepository;
	
	/*public TransferService(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}*/

	public void transfer(Long amount, Long a, Long b){
		Account accountA = accountRepository.findAccountById(a);
		Account accountB = accountRepository.findAccountById(b);
		System.out.println("Amount has been transfered from "+accountA +" to "+accountB);
	}

	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
}
