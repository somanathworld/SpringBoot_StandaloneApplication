package com.nt.service;

import org.springframework.stereotype.Service;

@Service("store")
public class OnlineStore {

	public double shopping(String items[], double prices[]) {
		System.out.println("OnlineStore.shopping()");
		
		double billAmt = 0.0;
		for(double price : prices) {
			billAmt += price;
		}
		return billAmt;
	}
}
