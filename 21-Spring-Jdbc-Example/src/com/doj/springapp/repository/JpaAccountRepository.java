package com.doj.springapp.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.doj.springapp.model.Account;

@Repository
//@Primary
//@Order(2)
public class JpaAccountRepository implements AccountRepository {
	
	@Override
	public Account findAccountById(Long id) {
		return new Account(id);
	}

	@Override
	public List<Account> findAccountAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
