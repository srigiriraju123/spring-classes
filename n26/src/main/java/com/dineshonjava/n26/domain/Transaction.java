/**
 * 
 */
package com.dineshonjava.n26.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Dinesh.Rajput
 *
 */
public class Transaction implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Double amount;
	private LocalDateTime date;
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Transaction [amount=" + amount + ", date=" + date + "]";
	}
	
}
