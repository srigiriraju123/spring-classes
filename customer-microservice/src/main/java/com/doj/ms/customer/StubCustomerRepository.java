package com.doj.ms.customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

/**
 * @author Dinesh.Rajput
 *
 */
@Repository
public class StubCustomerRepository implements CustomerRepository {
	
	private Map<String, Customer> customersByNumber = new HashMap<>();
	
	public StubCustomerRepository() {
		Customer customer = new Customer(1000l, "Arnav" , "1111");
		customersByNumber.put("5115", customer);
		customer = new Customer(2000l, "Anamika" , "2222");
		customersByNumber.put("2089", customer);
		customer = new Customer(3000l, "Dinesh" , "3333");
		customersByNumber.put("1286", customer);
		Logger.getLogger(StubCustomerRepository.class).info("Created StubAccountRepository");
	}
	
	@Override
	public List<Customer> getAllCustomers() {
		return new ArrayList<>(customersByNumber.values());
	}

	@Override
	public Customer getCustomer(String number) {
		return customersByNumber.get(number);
	}

}
