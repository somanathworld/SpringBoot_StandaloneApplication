package com.nt.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.nt.service.ICoronaVaccineMgmtService;

//@Component
//@Order(1)
public class Test01_FinderMethod_EntityQuries implements CommandLineRunner{

	@Autowired
	private ICoronaVaccineMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
//		service.fetchVaccinesByCompany("Russie").forEach(System.out::println);
//		service.fetchVaccinesByPrice(800).forEach(System.out::println);
//		service.fetchVaccineByPrice(500, 800).forEach(System.out::println);
//		service.fetchVaccineByStartName("py").forEach(System.out::println);
//		service.fetchVaccineByStatingWithName("p").forEach(System.out::println);
//		service.fetchVaccineByEndingWithName("r").forEach(System.out::println);
//		service.fetchVaccineByContainingName("p").forEach(System.out::println);
//		service.fetchVaccineByCountries(Arrays.asList("USA", "Russia")).forEach(System.out::println);
		service.fetchVaccineByPriceAscOrderder(700).forEach(System.out::println);;

	}
	
}
