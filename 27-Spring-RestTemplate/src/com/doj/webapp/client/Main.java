/**
 * 
 */
package com.doj.webapp.client;

import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.doj.webapp.model.Account;

/**
 * @author Dinesh.Rajput
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		RestClient restClient = applicationContext.getBean(RestClient.class);
		Account account = restClient.findAccount(1000l, "http://localhost:8080/26-Spring-REST/accounts/1000");
		System.out.println(account);
		List<Account> accounts = restClient.findAllAccount("http://localhost:8080/26-Spring-REST/all-accounts");
		System.out.println(accounts);
		applicationContext.close();*/
		RestTemplate restTemplate = new RestTemplate();
		Account account = restTemplate.getForObject("http://localhost:8080/26-Spring-REST/accounts/1000", Account.class);
		List<Account>  accounts = restTemplate.getForObject("http://localhost:8080/26-Spring-REST/all-accounts", List.class);
		System.out.println(account);
		System.out.println(accounts);
	}

}
