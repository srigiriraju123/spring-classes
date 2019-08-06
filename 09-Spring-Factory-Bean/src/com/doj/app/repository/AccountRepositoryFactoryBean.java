/**
 * 
 */
package com.doj.app.repository;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author Dinesh.Rajput
 *
 */
public class AccountRepositoryFactoryBean implements FactoryBean<IAccountRepository> {

	@Override
	public IAccountRepository getObject() throws Exception {
		//add your logic
		System.out.println("Creating Bean by AccountRepositoryFactoryBean");
		return new AccountRepository();
	}

	@Override
	public Class<?> getObjectType() {
		return IAccountRepository.class;
	}

	@Override
	public boolean isSingleton() {
		System.out.println("Deciding Scope of Bean by AccountRepositoryFactoryBean");
		return true;
	}

}
