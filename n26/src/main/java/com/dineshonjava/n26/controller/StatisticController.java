/**
 * 
 */
package com.dineshonjava.n26.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dineshonjava.n26.domain.Statistic;
import com.dineshonjava.n26.exception.TransactionExpiredException;
import com.dineshonjava.n26.exception.TransactionOutOfFutureWindow;
import com.dineshonjava.n26.service.StatisticService;

/**
 * @author Dinesh.Rajput
 *
 */
@RestController
public class StatisticController {
	
	@Autowired
	StatisticService statisticService;
	
	@GetMapping("/statistics")
	public ResponseEntity<Statistic> findCurrent() throws TransactionExpiredException, TransactionOutOfFutureWindow {
		Statistic statistic = statisticService.findCurrent();
		return new ResponseEntity<>(statistic, HttpStatus.OK);
	}
}
