package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BankDAOImpl implements IBankDAO {

	private static final String BANK_WITHDRAW = "UPDATE SPRING_TX_BANK SET BALANCE=BALANCE-? WHERE ACCNO=?";
	private static final String BANK_DEPOSITE = "UPDATE SPRING_TX_BANK SET BALANCE=BALANCE+? WHERE ACCNO=?";
	
	@Autowired
	JdbcTemplate template;
	
	@Override
	public int withdraw(int accNo, double amount) {
		int count = template.update(BANK_WITHDRAW, amount, accNo);
		return count;
	}
	
	@Override
	public int deposite(int accNo, double amount) {
		int count = template.update(BANK_DEPOSITE,amount, accNo);
		return count;
	}

}
