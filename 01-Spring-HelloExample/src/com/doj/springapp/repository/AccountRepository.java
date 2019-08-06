/**
 * 
 */
package com.doj.springapp.repository;

import com.doj.springapp.model.Account;

/**
 * @author Dinesh.Rajput
 *
 */
public class AccountRepository {
	
	public Account findAccountById(Long id){
		return new Account(id);
	}
}
