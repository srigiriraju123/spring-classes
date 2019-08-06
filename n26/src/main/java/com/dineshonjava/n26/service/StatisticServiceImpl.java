/**
 * 
 */
package com.dineshonjava.n26.service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.dineshonjava.n26.domain.Statistic;
import com.dineshonjava.n26.domain.Transaction;
import com.dineshonjava.n26.exception.TransactionExpiredException;
import com.dineshonjava.n26.exception.TransactionOutOfFutureWindow;
import com.dineshonjava.n26.utils.CommonUtils;

/**
 * @author Dinesh.Rajput
 *
 */
@Service
public class StatisticServiceImpl implements StatisticService{
	private Object LOCK = new Object();
	private Map<Long, Statistic> statisticHistory;
	private Queue<Long> statisticTimestamps;
	
	@Value("${statisticService.windowInMs}")
	private Long windowInMs;
	
	public StatisticServiceImpl() {
		 this.statisticHistory = new ConcurrentHashMap<>();
		 this.statisticTimestamps = new PriorityBlockingQueue<>();
	}
	
	private Statistic createInitStatistic(Long timestamp) {
		Statistic statistic = new Statistic();
		statistic.setDate(CommonUtils.convertToLocalDateTime(timestamp));
		statistic.setMax(Double.MIN_VALUE);
		statistic.setMin(Double.MAX_VALUE);
		statistic.setSum(0.0);
		statistic.setCount(0l);
		return statistic;
	}
	
	@Override
	public Statistic findCurrent()  throws TransactionExpiredException, TransactionOutOfFutureWindow {
		Long currentTimestamp = CommonUtils.converToTimeStamp(LocalDateTime.now());
		Statistic statistic = this.statisticHistory.get(currentTimestamp);
		if (statistic == null) statistic = this.createInitStatistic(currentTimestamp);
		return statistic;
	}

	@Override
	public void add(Transaction transaction)  throws TransactionExpiredException, TransactionOutOfFutureWindow {
		Long currentTimestamp = CommonUtils.converToTimeStamp(LocalDateTime.now());
		Long transactionTimestamp = CommonUtils.converToTimeStamp(transaction.getDate());
		if (transactionTimestamp + windowInMs < currentTimestamp) throw new TransactionExpiredException();
		if (currentTimestamp + windowInMs < transactionTimestamp) throw new TransactionOutOfFutureWindow();
		
		synchronized(LOCK) {
			
			for(Long i = currentTimestamp; i < transactionTimestamp + windowInMs; i+=1000) {
				Statistic statistic = this.statisticHistory.get(i);
				if (statistic == null) {
					statistic = this.createInitStatistic(i);
					this.statisticHistory.put(i, statistic);
					this.statisticTimestamps.add(i);
				}
				if (transaction.getAmount() > statistic.getMax()) statistic.setMax(transaction.getAmount());
				if (transaction.getAmount() < statistic.getMin()) statistic.setMin(transaction.getAmount());
				
				statistic.setSum( statistic.getSum() + transaction.getAmount() );
				statistic.setCount( statistic.getCount() + 1);
				statistic.setAvg( statistic.getSum() / statistic.getCount() );
			}
		
		}
	}
	
	@Scheduled(fixedDelayString = "${statisticService.removeExpiredStatisticsInMs}")
	private void removeExpiredStatistics() {

		Long currentTimestamp = CommonUtils.converToTimeStamp(LocalDateTime.now());
		
		if (this.statisticTimestamps.isEmpty() || this.statisticTimestamps.peek() >= currentTimestamp) return;
		
		synchronized(LOCK) {
		
			while(!this.statisticTimestamps.isEmpty() && this.statisticTimestamps.peek() < currentTimestamp) {
				Long key = this.statisticTimestamps.poll();
				this.statisticHistory.remove(key);
			}
		}
	}
}
