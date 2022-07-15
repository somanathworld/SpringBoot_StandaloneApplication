package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.nt.entity.CoronaVaccine;
import com.nt.service.ICoronaVaccineServiceMgmt;

@Component
public class Test01_SortData implements CommandLineRunner{

	@Autowired
	private ICoronaVaccineServiceMgmt service;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			CoronaVaccine vaccine = new CoronaVaccine();
			vaccine.setCompany("Russie");
			vaccine.setPrice(600.0);
			service.searchVaccinesByGivenData(vaccine, true, "price").forEach(System.out::println);
		}catch(DataAccessException dae) {
			dae.printStackTrace();
		}
	}
}
