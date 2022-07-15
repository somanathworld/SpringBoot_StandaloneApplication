package com.nt.dao;

public interface IBankDAO {

	public int withdraw(int accNo, double amount);
	public int deposite(int accNo, double amount);
}
