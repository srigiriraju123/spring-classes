/**
 * 
 */
package com.doj.springapp.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.doj.springapp.model.Account;

/**
 * @author Dinesh.Rajput
 *
 */
@Repository
//@Order(1)
//@Primary
@Profile("dev")
public class JdbcAccountRepository implements AccountRepository{
	
	@Override
	public Account findAccountById(Long id){
		System.out.println("Using JDBC");
		return new Account(id);
	}
}
