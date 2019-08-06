/**
 * 
 */
package com.doj.ms.customer;

import java.io.Serializable;
import java.util.List;

/**
 * @author Dinesh.Rajput
 *
 */
public class Customer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String pesel;
	private String name;
	private List<Account> accounts;
	
	public Customer() {
		super();
	}
	public Customer(Long id, String pesel, String name) {
		super();
		this.id = id;
		this.pesel = pesel;
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPesel() {
		return pesel;
	}
	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
}
