/**
 * 
 */
package com.doj.ms.customer;

import java.util.List;

/**
 * @author Dinesh.Rajput
 *
 */
public interface CustomerRepository {
	
	List<Customer> getAllCustomers();
	
	Customer getCustomer(String number);
}
