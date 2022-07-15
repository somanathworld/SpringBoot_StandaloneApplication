package com.nt.runners;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.ICoronaVaccineMgmtService;

//@Component
public class Test01_EntityQueries_MultipleRecords implements CommandLineRunner{

	@Autowired
	private ICoronaVaccineMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
//		service.fetchVaccinesByCompany("Pyzer").forEach(System.out::println);
//		service.fetchVaccinesByCompanies("Pyzer", "Russie", "Mod").forEach(System.out::println);
//		service.fetchVaccineDetailsByNames("pyzer", "covaxin")
//		.forEach(vaccine->{
//			for(Object val : vaccine)
//				System.out.print(val+" ");
//			System.out.println();
//		});

//		service.fetchVaccineNamesByPriceRange(500, 800).forEach(System.out::println);
	}
}
