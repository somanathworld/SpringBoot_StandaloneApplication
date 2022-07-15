package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.nt.service.ICoronaVaccineMgmtService;

//@Component
//@Order(4)
public class Test04_NonSelectOperations implements CommandLineRunner{

	@Autowired
	private ICoronaVaccineMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		
//		System.out.println(service.modifyVaccinePriceByCountry(650, "Russia"));
		System.out.println(service.removalVaccinesByPriceRange(600, 700));
	}
	
}
