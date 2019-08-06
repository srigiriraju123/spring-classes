/**
 * 
 */
package com.doj.springapp.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
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
//@Transactional(transactionManager = "transactionManager", isolation =Isolation.READ_COMMITTED, propagation=Propagation.REQUIRED, readOnly=true, timeout=60)
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
	//@Transactional
	@Transactional(timeout=30,rollbackFor=Exception.class, rollbackForClassName="Exception", propagation =Propagation.REQUIRED) //Demarcation
	public void transfer(Long amount, Long a, Long b){
		Account accountA = accountRepository.findAccountById(a);//update 1-OK//rollback//connect
		Account accountB = accountRepository.findAccountById(b);////update 2//rollback//connect//close
		//transferRepository.tranfer(amount, accountB); ////update 3-Not OK-
		System.out.println("Amount has been transfered from "+accountA +" to "+accountB);
		//otherservice.call();
		System.out.println(accountRepository.findAccountAll());
	}
}

//Low level Isolation
//1. Read_uncommited//dirty data T1-read data from table "account", T2-Insert another account entry --excep
//2. Read_committed//avoid dirty ready //non-repeatable read

//High Level Isolation
//1. Serializable-//avoid dirty read, avoid non-repeatable read, avoid phantom read
//2. Repeatable_read//avoid dirty read, avoid non-repeatable read, not avoid phantom

//Default Behavior
//timeout=depends on underlying vendor
//rollback-runtime exception
//readonly=false
//isolation=Read_committed
//propagation=REQUIRED
//name=transactionManager


//REQUIRED-use current tnx else create new tnx if not 
//REQUIRE_NEW-always create new tnx and suspend old one
//SUPPORTS-use current tnx else execute without tnx
//MANDATORY-use current tnx else throw exception
//NOT-SUPPORTED-always execute non txn if any tnx there suspend it
//NESTED-created nested tnx under current tnx
//NEVER-always excecute without tnx if there throw exception

