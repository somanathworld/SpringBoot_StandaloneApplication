package com.nt.comp;

public class Bank {
	
	public double calculateInterestAmount(float pAmnt, float rate, float time) {
		System.out.println("Bank.calculateInterestAmount()");
		return (pAmnt*Math.pow((1+rate/100),time) - pAmnt);
	}
}
