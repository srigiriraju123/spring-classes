/**
 * 
 */
package com.doj.app.service;

import com.doj.app.repository.IAccountRepository;

/**
 * @author Dinesh.Rajput
 *
 */
public class AccountService {
	
	IAccountRepository accountRepository;
	
	public AccountService(IAccountRepository accountRepository){
		this.accountRepository = accountRepository;
	}
}
