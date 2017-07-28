/**
 * 
 */
package com.doj.springapp.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.doj.springapp.model.Account;
import com.doj.springapp.repository.AccountRepository;
import com.doj.springapp.repository.TransferRepository;

/**
 * @author Dinesh.Rajput
 *
 */
@Service
@Transactional(transactionManager = "transactionManager", isolation =Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, readOnly=true)
public class TransferServiceImpl implements TransferService{
	//1. always resolve dependency by type if failure then its try with by property name
	@Resource(name="jdbcAccountRepository") 
	AccountRepository accountRepository;
	
	TransferRepository transferRepository;
	//As of Spring 4.3 if any class has single argument constructor then no need too define dependency definition to container
	//autowired always resolve dependency by type
	/*@Autowired 
	public TransferServiceImpl(@Qualifier("jpaAccountRepository") AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}*/
	
	@Override
	@Transactional //Demarcation
	public void transfer(Long amount, Long a, Long b){
		Account accountA = accountRepository.findAccountById(a);//update 1-OK//rollback//connect
		Account accountB = accountRepository.findAccountById(b);////update 2//rollback//connect//close
		transferRepository.tranfer(amount, accountB); ////update 3-Not OK-
		System.out.println("Amount has been transfered from "+accountA +" to "+accountB);
	}
}