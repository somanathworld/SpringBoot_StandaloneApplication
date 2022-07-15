package com.nt.comp;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component("fkart")
public class Flipkart {

	@Autowired
	Environment env;
	
	@Autowired
	@Qualifier("dtdc")
	private Courier courier;
	
	@PostConstruct
	public void startBean(){
		System.out.println("Flipkart.initilization");
	}
	
	public String shop(String[] items, float[] prices) {
		
		System.out.println("Welcome to Flipkart."+env.getProperty("depend"));

		return courier.delivered(items, prices);
	}
	
	@PreDestroy
	public void endBean() {
		System.out.println("Flipkart.destruction");
		
	}
}
