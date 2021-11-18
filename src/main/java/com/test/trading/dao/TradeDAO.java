package com.test.trading.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.test.trading.exception.TradingException;
import com.test.trading.model.Trade;

@Repository
public class TradeDAO {

	private Map<String , List<Trade>> tradeStore;
	
	@PostConstruct
	public void setup() {
		tradeStore = new ConcurrentHashMap<>();
	}
	
	
	public Trade getLatestVersionTrade(String tradeID) {

		Trade highestVersionTrade = null;
		
		for(String tradeKey : tradeStore.keySet()) {
			if(tradeID.equals(tradeKey)) {
				long tradeVersion = 0;
				for(Trade trade : tradeStore.get(tradeKey)) {
					if(trade.getVersion() > tradeVersion) {
						tradeVersion = trade.getVersion();
						highestVersionTrade = trade;
					}
					

				}
			}
		}
		return highestVersionTrade;

		}
	
	public String addTrade(Trade _tradeToAdd) {
		
		boolean tradeToReject = false;
		
		List<Trade> tradeList = null;
		String tradeStoreKey = _tradeToAdd.getTradeID();
		if(tradeStore.containsKey(tradeStoreKey)){
			tradeList = tradeStore.get(tradeStoreKey);
			for(Trade trade : tradeList){
				
				if(trade.getVersion() > _tradeToAdd.getVersion()) {
					// there is alreday one trade with higher version , this version to be rejected 
					tradeToReject = true;
				}
			}
			if(tradeToReject){
				throw new TradingException(" a higher version of trade exist " );
			}else {
				tradeList.add(_tradeToAdd);
			}
			
		}else {
			 tradeList = new ArrayList<>();
			tradeList.add(_tradeToAdd);
		}
		
		tradeStore.put(tradeStoreKey, tradeList);
		return "Trade added to Trade Store";
	}
	
	
	public void updateExpiry() {
		
		for(String tradeKey : tradeStore.keySet()) {
			
			for(Trade trade : tradeStore.get(tradeKey)) {
				Calendar currentTime =Calendar.getInstance();
				
				if(trade.getMaturityDate().after(currentTime.getTime())) {
					trade.setExpired(true);
				}
			}
		}
	}
}
