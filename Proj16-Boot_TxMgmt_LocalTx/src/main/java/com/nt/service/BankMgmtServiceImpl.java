package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.IBankDAO;

@Service("bankService")
public class BankMgmtServiceImpl implements IBankMgmtService{

	@Autowired
	private IBankDAO dao; 
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, 
					transactionManager = "transactionManager",
					rollbackFor = IllegalAccessException.class, 
					timeout = 20)
	public String transferMoney(int srcAccNo, int destAccNo, double amount) {
		int count1 = dao.withdraw(srcAccNo, amount);
		int count2 = dao.deposite(destAccNo, amount);
		
		if(count1 == 0 || count2 == 0) {
			throw new RuntimeException("Tx rolled back-->Money is not transfered.");
		}else {
			return "Tx committed-->Money transfered.";
		}
		
	}
}
