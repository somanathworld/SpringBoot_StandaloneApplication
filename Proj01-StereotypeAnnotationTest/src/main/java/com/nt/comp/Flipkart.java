package com.nt.comp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("fkart")
public class Flipkart {

	@Autowired
	@Qualifier("cr")
	private Courier courier;
	
	public String shop(String[] items, float[] prices) {
		
		System.out.println("Welcome to Flipkart.");

		return courier.delivered(items, prices);
	}
}
