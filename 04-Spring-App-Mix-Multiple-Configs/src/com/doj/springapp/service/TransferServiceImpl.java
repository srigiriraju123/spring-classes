/**
 * 
 */
package com.doj.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doj.springapp.model.Account;
import com.doj.springapp.repository.AccountRepository;

/**
 * @author Dinesh.Rajput
 *
 */
@Service
public class TransferServiceImpl implements TransferService{
	//1. always resolve dependency by type if failure then its try with by property name//JSR 250-J2ee
	//@Resource(name="jdbcAccountRepository") 
	@Autowired
	//@Qualifier("jpaAccountRepository")
	AccountRepository accountRepository;
	//As of Spring 4.3 if any class has single argument constructor then no need too define dependency definition to container
	//autowired always resolve dependency by type
	/*@Autowired  @Qualifier("jpaAccountRepository") 
	public TransferServiceImpl(@Qualifier("jdbcAccountRepository") AccountRepository jpaAccountRepository) {
		super();
		this.jpaAccountRepository = jpaAccountRepository;
	}*/
	/*@Resource(name="jdbcAccountRepository") 
	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}*/

	@Override
	public void transfer(Long amount, Long a, Long b){
		Account accountA = accountRepository.findAccountById(a);
		Account accountB = accountRepository.findAccountById(b);
		System.out.println("Amount has been transfered from "+accountA +" to "+accountB);
	}
}
