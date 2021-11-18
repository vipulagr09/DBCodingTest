package com.test.trading.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import com.test.trading.dao.TradeDAO;
import com.test.trading.model.Trade;


public class TestTradingService {

	
	private TradeService tradeService ;
	@InjectMocks
	private TradeDAO tradeDAO;
	
	@BeforeEach
	public void setup() {
		
		tradeDAO = Mockito.mock(TradeDAO.class);
		tradeService = new TradeService(tradeDAO,new ArrayList<>() );
		Mockito.when(tradeDAO.addTrade(Mockito.any())).thenReturn("trade added ");
	}
	
	@Test
	public void testAddTrade() {
		
		Trade _trade = createTrade();
		tradeService.addTrade(_trade);
		Mockito.when(tradeDAO.getLatestVersionTrade(_trade.getTradeID())).thenReturn(_trade);
		
		Trade bookedTrade =  tradeService.latestVersionTrade(_trade.getTradeID());
		assertTrue(_trade.getVersion()== bookedTrade.getVersion());
	}
	
	private Trade createTrade() {
		Trade newTrade = new Trade();
		
		newTrade.setBookID("book123");
		newTrade.setTradeID("test123");
		newTrade.setVersion(12);
		newTrade.setCounterPartyID("CP123");
		Calendar maturityDate = Calendar.getInstance();
		maturityDate.add(Calendar.DAY_OF_MONTH, 2);
		newTrade.setMaturityDate(maturityDate.getTime());
		newTrade.setCreationDate(Calendar.getInstance().getTime());
		newTrade.setExpired(false);
		
		return newTrade;
	}
}
