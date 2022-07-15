package com.nt.runners;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.nt.service.ICoronaVaccineMgmtService;

@Component
@Order(6)
class Test06_NativeSqlQuery_PlSqlOperation implements CommandLineRunner{

	@Autowired
	private ICoronaVaccineMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		
//		service.searchVaccinesByPriceRange(400.0f, 900.0f).forEach(System.out::println);
//		System.out.println(service.authenticate("raja", "rani1"));
		
		for(Object obj : service.getEmpDetailsByEno(7788)) {
			System.out.print(obj + " ");			
		}
		System.out.println();
	}
	
}
