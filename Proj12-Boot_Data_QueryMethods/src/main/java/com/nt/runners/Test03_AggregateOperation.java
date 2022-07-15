package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.nt.service.ICoronaVaccineMgmtService;

//@Component
//@Order(3)
public class Test03_AggregateOperation implements CommandLineRunner{

	@Autowired
	private ICoronaVaccineMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Vaccine count : "+service.fetchVaccineCount());
		Object[] obj = (Object[])service.fetchVaccinesAggregateDataByPriceRange(500, 800);
		for(Object value : obj)
			System.out.print(value + " ");
		System.out.println();
	}
	
}
