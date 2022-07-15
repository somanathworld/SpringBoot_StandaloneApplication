package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("withdrawDAO")
public class WithdrawDAOImpl implements IWithdrawDAO {

	private static final String WITHDRAW_QUERY = "UPDATE DTX_BANK_ACCOUNT SET BALANCE=BALANCE-? WHERE ACNO=?";

	@Autowired
	@Qualifier("mysqlJT")
	private JdbcTemplate template;

	@Override
	public int withdraw(long accno, double amount) {
		int count = template.update(WITHDRAW_QUERY, amount, accno);
		return count;
	}
}
