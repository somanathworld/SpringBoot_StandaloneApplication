package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IBankMgmtService;

@Component
public class Test01_DistributedTx implements CommandLineRunner{

	@Autowired
	private IBankMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println(service.transferMoney(1002, 1001, 5000.0));
	}
	
}
