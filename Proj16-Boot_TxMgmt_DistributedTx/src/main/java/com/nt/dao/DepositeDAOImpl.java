package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("depositeDAO")
public class DepositeDAOImpl implements IDepositeDAO{

	private static final String DEPOSITE_QUERY = "UPDATE DTX_BANK_ACCOUNT SET BALANCE=BALANCE+? WHERE ACCNO=?"; 

	@Autowired
	@Qualifier("oraJT")
	private JdbcTemplate template;
	
	@Override
	public int deposite(long accno, double amount) {
		int count = template.update(DEPOSITE_QUERY, amount, accno);
		return count;
	}
	
}
