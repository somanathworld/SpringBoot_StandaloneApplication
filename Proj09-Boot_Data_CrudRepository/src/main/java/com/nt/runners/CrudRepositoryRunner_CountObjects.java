package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.nt.entity.CoronaVaccine;
import com.nt.service.ICoronaVaccineMgmtService;

//@Component
//@Order(3)
public class CrudRepositoryRunner_CountObjects implements CommandLineRunner{

	@Autowired
	private ICoronaVaccineMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		
		try {
			System.out.println("Records count : "+service.getVaccineCount());
		}catch(DataAccessException dae) {
			dae.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
