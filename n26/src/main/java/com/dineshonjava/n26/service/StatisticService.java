/**
 * 
 */
package com.dineshonjava.n26.service;

import com.dineshonjava.n26.domain.Statistic;
import com.dineshonjava.n26.domain.Transaction;
import com.dineshonjava.n26.exception.TransactionExpiredException;
import com.dineshonjava.n26.exception.TransactionOutOfFutureWindow;

/**
 * @author Dinesh.Rajput
 *
 */
public interface StatisticService {
	
	Statistic findCurrent()throws TransactionExpiredException, TransactionOutOfFutureWindow;
	
	void add(Transaction transaction) throws TransactionExpiredException, TransactionOutOfFutureWindow;
}
