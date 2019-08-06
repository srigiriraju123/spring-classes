/**
 * 
 */
package com.dineshonjava.n26.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dineshonjava.n26.domain.Transaction;
import com.dineshonjava.n26.domain.TransactionPostJson;
import com.dineshonjava.n26.exception.TransactionExpiredException;
import com.dineshonjava.n26.exception.TransactionOutOfFutureWindow;
import com.dineshonjava.n26.service.TransactionService;

/**
 * @author Dinesh.Rajput
 *
 */
@RestController
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@PostMapping("/transactions")
	public ResponseEntity<Transaction> post(@RequestBody @Valid TransactionPostJson bodyJson) {

		try {
			Transaction transaction = this.transactionService.process(bodyJson);
			return  new ResponseEntity<>(transaction, HttpStatus.CREATED); 
		} 
		catch (TransactionExpiredException | TransactionOutOfFutureWindow e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
