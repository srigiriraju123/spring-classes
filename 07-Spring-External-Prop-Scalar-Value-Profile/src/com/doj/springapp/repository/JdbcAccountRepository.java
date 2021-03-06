/**
 * 
 */
package com.doj.springapp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.doj.springapp.model.Account;

/**
 * @author Dinesh.Rajput
 *
 */
@Repository
public class JdbcAccountRepository implements AccountRepository{
	
	@Autowired///how resolve di-BPP
	AppDataSource dataSource;
	
	@Override
	public Account findAccountById(Long id){
		System.out.println(dataSource);
		return new Account(id);
	}
}
