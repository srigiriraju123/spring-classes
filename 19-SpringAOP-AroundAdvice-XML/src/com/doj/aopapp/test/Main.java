/**
 * 
 */
package com.doj.aopapp.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.doj.aopapp.service.TransferService;

/**
 * @author Dinesh.Rajput
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		TransferService transferService = applicationContext.getBean(TransferService.class);
		transferService.transfer("accountA", "accountB", 50000l);
		transferService.checkBalance("accountA");
		transferService.diposite("accountA",  50000l);
		transferService.withdrawal("accountB", 40000l);
		applicationContext.close();
	}

}
