/**
 * 
 */
package com.doj.ms.customer;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dinesh.Rajput
 *
 */
@RestController
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository; 
	
	@Autowired
	AccountRepository accountRepository;
	
	@GetMapping(value = "/customers/pesel/{pesel}", produces="application/json")
	public Customer findByPesel(@PathVariable("pesel") String pesel) {
		Logger.getLogger(CustomerController.class).info(String.format("Customer.findByPesel(%s)", pesel));
		return customerRepository.getAllCustomers().stream().filter(it -> it.getPesel().equals(pesel)).findFirst().get();	
	}
	
	@GetMapping(value = "/customers", produces="application/json")
	public List<Customer> findAll() {
		Logger.getLogger(CustomerController.class).info("Customer.findAll()");
		return customerRepository.getAllCustomers();
	}
	
	@GetMapping(value = "/customers/{id}", produces="application/json")
	public Customer findById(@PathVariable("id") Integer id) {
		Logger.getLogger(CustomerController.class).info(String.format("Customer.findById(%s)", id));
		Customer customer = customerRepository.getAllCustomers().stream().filter(it -> it.getId().intValue()==id.intValue()).findFirst().get();
		List<Account> accounts =  accountRepository.getAllAccounts();
		customer.setAccounts(accounts);
		return customer;
}
}
