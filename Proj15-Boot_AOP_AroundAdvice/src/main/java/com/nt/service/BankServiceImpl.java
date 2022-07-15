package com.nt.service;

import org.springframework.stereotype.Service;

@Service("bankService")
public class BankServiceImpl implements IBankService{

	@Override
	public double calcSimpleInterestAmount(double pAmnt, double rate, double time) {
		System.out.println("BankServiceImpl.calcSimpleInterestAmount() : "+pAmnt+" "+rate+" "+time);
		return (pAmnt * rate * time)/100;
	}
	
	@Override
	public double calcCompoundInterestAmount(double pAmnt, double rate, double time) {
		System.out.println("BankServiceImpl.calcCompoundInterestAmount() : "+pAmnt+" "+rate+" "+time);
		return 0;
	}
}
