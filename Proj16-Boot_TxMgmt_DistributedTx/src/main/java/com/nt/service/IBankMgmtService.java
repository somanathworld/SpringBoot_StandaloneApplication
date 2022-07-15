package com.nt.service;

public interface IBankMgmtService {

	public String transferMoney(long srcAccNo, long destAccNo, double amount);
}
