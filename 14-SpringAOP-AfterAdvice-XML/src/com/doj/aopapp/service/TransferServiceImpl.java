/**
 * 
 */
package com.doj.aopapp.service;

/**
 * @author Dinesh.Rajput
 *
 */
public class TransferServiceImpl implements TransferService {

	@Override
	public void transfer(String accountA, String accountB, Long amount) {
		System.out.println(amount+" Amount has been tranfered from "+accountA+" to "+accountB);
	}

	@Override
	public Double checkBalance(String account) {
		System.out.println("Available balance: 50000");
		return new Double(50000);
	}

	@Override
	public Long withdrawal(String account, Long amount) {
		System.out.println("Withdrawal amount: " +amount);
		return amount;
	}

	@Override
	public void diposite(String account, Long amount) {
		System.out.println(amount+" Amount has been diposited to "+account);
	}

}
