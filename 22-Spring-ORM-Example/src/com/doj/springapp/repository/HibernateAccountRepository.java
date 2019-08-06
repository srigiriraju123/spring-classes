package com.doj.springapp.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.doj.springapp.model.Account;

@Repository
public class HibernateAccountRepository implements AccountRepository {
	
	//HibernateTemplate hibernateTemplate;
	@Autowired
	SessionFactory sessionFactory;
	
	public HibernateAccountRepository(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
		//hibernateTemplate = new HibernateTemplate(sessionFactory);
	}


	@Override
	public Account findAccountById(Long id) {//it is SQL, it HQL-Hibernate Query Language
		return (Account) sessionFactory.getCurrentSession().createQuery("FROM Account WHERE id="+id).getSingleResult();
		//return (Account) hibernateTemplate.find("FROM Account WHERE id=?", id).get(0);
	}
	
	@Override
	public List<Account> findAll() {//it is SQL, it HQL-Hibernate Query Language
		return ( List<Account>) sessionFactory.getCurrentSession().createQuery("FROM Account").getResultList();
		//return (List<Account>) hibernateTemplate.find("FROM Account");
	}


	@Override
	public Long save(Account account) {
		return (Long) sessionFactory.getCurrentSession().save(account);
	}
}
