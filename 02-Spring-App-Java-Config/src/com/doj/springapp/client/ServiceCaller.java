/**
 * 
 */
package com.doj.springapp.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.doj.springapp.config.AppConfig;
import com.doj.springapp.service.TransferService;

/**
 * @author Dinesh.Rajput
 *
 */
public class ServiceCaller {

	/**
	 * @param args
	 * 1. Service caller creating Repository
	 * 2. Service caller has extra responsibility to create the object service as well as repository
	 * 3. Here our service class is tightly coupled with repository
	 */
	public static void main(String[] args) {
		//Traditional way for java application
		//AccountRepository accountRepository = new AccountRepository();//very critical class
		//TransferService service = new TransferService(accountRepository);
		
		//Using Spring 
		//1. resolved 
		//2. resolved
		//3. resolved
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		//We have to downcast-find bean by name
		//TransferService transferService = (TransferService) applicationContext.getBean("transferService");
		System.out.println("LAZZZY");
		//TransferService transferService = applicationContext.getBean("transferService",TransferService.class);
		//No need to downcast-find bean by type-recommended
		TransferService transferService = applicationContext.getBean(TransferService.class);
		transferService.transfer(200l, 1l, 2l);
	}

}
