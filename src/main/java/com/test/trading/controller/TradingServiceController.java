package com.test.trading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.trading.exception.TradingException;
import com.test.trading.model.Trade;
import com.test.trading.service.TradeService;

@RestController()
public class TradingServiceController {

	
	@Autowired
	private TradeService tradeService;
	
	@GetMapping("/getSome")
	public String getData() {
		
		return "test data";
	}
	
	@PostMapping(path="/postTrade" , consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addTrade(@RequestBody Trade _trade) {
		try {
		System.out.println(" data sent " + _trade);
		
		tradeService.addTrade(_trade);
		}catch(TradingException e){
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.EXPECTATION_FAILED) ;
		}
		
		return new ResponseEntity<String>("Trade Created ",HttpStatus.CREATED) ;
		
	}
}
