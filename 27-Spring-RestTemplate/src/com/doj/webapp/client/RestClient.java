/**
 * 
 */
package com.doj.webapp.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.doj.webapp.model.Account;

/**
 * @author Dinesh.Rajput
 *
 */
@Component
public class RestClient {
	
	@Autowired
	RestTemplate restTemplate;
	/**
	 * @param args
	 */
	public Account findAccount(Long id, String url) {
		return restTemplate.getForObject(url, Account.class);
	}
	public List<Account> findAllAccount(String url) {
		return restTemplate.getForObject(url, List.class);
	}

}
