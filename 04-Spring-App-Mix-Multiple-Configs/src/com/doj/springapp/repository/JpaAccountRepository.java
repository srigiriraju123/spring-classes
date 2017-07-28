package com.doj.springapp.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.doj.springapp.model.Account;

@Repository("accountRepository")
//@Primary
//@Order(2)
@Profile("prod")
public class JpaAccountRepository implements AccountRepository {

	@Override
	public Account findAccountById(Long id) {
		System.out.println("Using JPA");
		return new Account(id);
	}

}
