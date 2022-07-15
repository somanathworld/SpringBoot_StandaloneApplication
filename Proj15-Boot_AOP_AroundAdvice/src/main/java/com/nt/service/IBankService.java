package com.nt.service;

public interface IBankService {

	public double calcSimpleInterestAmount(double pAmnt, double rate, double time);
	public double calcCompoundInterestAmount(double pAmnt, double rate, double time);
	
}
