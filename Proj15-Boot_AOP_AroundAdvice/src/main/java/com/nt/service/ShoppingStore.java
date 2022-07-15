package com.nt.service;

import org.springframework.stereotype.Service;

@Service("shoppingStore")
public class ShoppingStore {

	public double calcBillAmount(double price, double qty) {
		System.out.println("ShoppingStore.calcBillAmount()");
		if(price<0.0 || qty<=0.0) {
			throw new IllegalArgumentException("Invalid price and qty.");
		}
		double billAmnt = price * qty;
		return billAmnt;
	}
}
