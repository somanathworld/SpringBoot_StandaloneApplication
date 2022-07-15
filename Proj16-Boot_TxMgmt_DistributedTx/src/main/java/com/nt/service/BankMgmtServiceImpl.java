package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.IDepositeDAO;
import com.nt.dao.IWithdrawDAO;

@Service
public class BankMgmtServiceImpl implements IBankMgmtService{

	@Autowired
	private IWithdrawDAO wDao;
	
	@Autowired
	private IDepositeDAO dDao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String transferMoney(long srcAccNo, long destAccNo, double amount) {
		int count1 = wDao.withdraw(srcAccNo, amount);
		int count2 = dDao.deposite(destAccNo, amount);
		System.out.println(count1 +" "+count2);
		if(count1 == 0 || count2 == 0) {
			throw new RuntimeException("Tx-roll back - Money not transferred.");
		}else {
			return "Tx-committed Money";
		}
		
	}
}
