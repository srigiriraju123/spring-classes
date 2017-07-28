/**
 * 
 */
package com.doj.webapp.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Dinesh.Rajput
 *
 */
@XmlRootElement (name = "accounts")
public class AccountVO {
	List<Account> account;

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}
	
	
}
