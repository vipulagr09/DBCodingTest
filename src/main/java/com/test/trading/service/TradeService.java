package com.test.trading.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.test.trading.dao.TradeDAO;
import com.test.trading.model.Trade;
import com.test.trading.validator.TradeValidator;

@Service
public class TradeService {

	private List<TradeValidator> tradeValidators; 
	
	private TradeDAO tradeDAO;
	
	@Autowired
	public TradeService(TradeDAO tradeDAO , List<TradeValidator> tradeValidators) {
		this.tradeDAO = tradeDAO;
		this.tradeValidators = tradeValidators;
	}
	public Trade latestVersionTrade(String tradeID) {
		
		return tradeDAO.getLatestVersionTrade(tradeID);
	}
	
	public void addTrade(Trade _trade) {
		
		// do the trade validation first 
		for(TradeValidator validator : tradeValidators) {
			validator.validate(_trade);
		}
		
		tradeDAO.addTrade(_trade);
	}
	
	
	@Scheduled(fixedDelay = 100000)
	public void expireMaturedTrade() {
		System.out.println(" going to run the expiry thread ");
		tradeDAO.updateExpiry();
	}
	
	
}
