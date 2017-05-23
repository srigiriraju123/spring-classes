package com.doj.springapp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.doj.springapp.model.Account;

@Repository
public class JpaAccountRepository implements AccountRepository {
	
	@Autowired
	AppDataSource dataSource;

	@Override
	public Account findAccountById(Long id) {
		System.out.println(dataSource);
		return new Account(id);
	}

}
