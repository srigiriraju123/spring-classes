package com.doj.springapp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.doj.springapp.model.Account;

@Repository
public class JpaAccountRepository implements AccountRepository {
	
	EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager (EntityManager entityManager) {
		this. entityManager = entityManager;
	}
	
	@Override
	public Account findAccountById(Long id) {
		// TODO Auto-generated method stub
		return (Account) entityManager.createQuery("from Account where id="+id).getSingleResult();
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long save(Account account) {
		// TODO Auto-generated method stub
		entityManager.persist(account);
		return null;
	}

}
