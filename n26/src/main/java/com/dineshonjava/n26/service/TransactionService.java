/**
 * 
 */
package com.dineshonjava.n26.service;

import com.dineshonjava.n26.domain.Transaction;
import com.dineshonjava.n26.domain.TransactionPostJson;
import com.dineshonjava.n26.exception.TransactionExpiredException;
import com.dineshonjava.n26.exception.TransactionOutOfFutureWindow;

/**
 * @author Dinesh.Rajput
 *
 */
public interface TransactionService {
	
	Transaction process(TransactionPostJson json) throws TransactionExpiredException, TransactionOutOfFutureWindow;
}
