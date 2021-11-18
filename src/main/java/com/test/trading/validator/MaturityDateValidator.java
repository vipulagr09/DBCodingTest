package com.test.trading.validator;

import java.util.Calendar;

import org.springframework.stereotype.Component;

import com.test.trading.exception.TradingException;
import com.test.trading.model.Trade;

@Component
public class MaturityDateValidator implements TradeValidator{

	@Override
	public void validate(Trade _tradeToValidate) {
		
		Calendar currentTime = Calendar.getInstance();
		
		Calendar tradeMaturitydate =  Calendar.getInstance();
		tradeMaturitydate.setTime(_tradeToValidate.getMaturityDate());
		
		if(currentTime.after(tradeMaturitydate)) {
			throw new TradingException(" not correct maturity date ");
		}
		
	}

	
	
}
