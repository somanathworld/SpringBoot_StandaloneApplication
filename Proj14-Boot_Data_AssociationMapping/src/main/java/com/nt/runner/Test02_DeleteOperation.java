package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IPersonMgmtService;

//@Component
public class Test02_DeleteOperation implements CommandLineRunner{

	@Autowired
	private IPersonMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
//		System.out.println(service.deleteByPerson(65));
		System.out.println(service.deleteAllPhoneNumbersOfAPerson(67));
	}
	
}
