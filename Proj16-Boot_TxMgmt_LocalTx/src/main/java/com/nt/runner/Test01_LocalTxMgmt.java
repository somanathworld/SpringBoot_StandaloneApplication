package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IBankMgmtService;

@Component
public class Test01_LocalTxMgmt implements CommandLineRunner{

	@Autowired
	private IBankMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		String result = service.transferMoney(101, 1002, 5000.0);
		System.out.println(result);
	}
}
