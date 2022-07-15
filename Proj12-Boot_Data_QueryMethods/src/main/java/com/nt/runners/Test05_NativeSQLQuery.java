package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.nt.service.ICoronaVaccineMgmtService;

//@Component
//@Order(5)
public class Test05_NativeSQLQuery implements CommandLineRunner{

	@Autowired
	private ICoronaVaccineMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
//		System.out.println(service.registerVaccine("ABC", "XYZ", "ABC-X", 450, 3));
//		System.out.println(service.fetchSystemDate());
		System.out.println(service.createTempTable());
	}
	
}
