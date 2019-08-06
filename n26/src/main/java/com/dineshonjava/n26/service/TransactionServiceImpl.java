/**
 * 
 */
package com.dineshonjava.n26.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dineshonjava.n26.domain.Transaction;
import com.dineshonjava.n26.domain.TransactionPostJson;
import com.dineshonjava.n26.exception.TransactionExpiredException;
import com.dineshonjava.n26.exception.TransactionOutOfFutureWindow;
import com.dineshonjava.n26.utils.CommonUtils;

/**
 * @author Dinesh.Rajput
 *
 */
@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private StatisticService statisticService;

	@Override
	public Transaction process(TransactionPostJson json) throws TransactionExpiredException, TransactionOutOfFutureWindow {
		
		Transaction transaction = new Transaction();
		transaction.setAmount(json.getAmount());
		transaction.setDate(CommonUtils.convertToLocalDateTime(json.getTimestamp()));
		
		this.statisticService.add(transaction);
		
		return transaction;
		
	}
}
