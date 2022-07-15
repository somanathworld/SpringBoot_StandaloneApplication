package com.nt.runners;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.nt.entity.CoronaVaccine;
import com.nt.service.ICoronaVaccineMgmtService;

//@Component
//@Order(7)
public class CrudRepositoryRunner_SelectObject implements CommandLineRunner{

	@Autowired
	private ICoronaVaccineMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		
		try {
			Optional<CoronaVaccine> vaccine1 = service.fetchVaccineById(13L);
			if(vaccine1.isPresent())
				System.out.println(vaccine1.get());
			else
				System.out.println("record not found.");

//			Optional<CoronaVaccine> vaccine2 = service.fetchVaccineById(13L);
//			if(vaccine2.isPresent())
//				System.out.println(vaccine2.get());
//			vaccine2.orElseThrow(()-> new IllegalArgumentException("record not found. "));

			Optional<CoronaVaccine> vaccine3 = service.fetchVaccineById(13L);
			if(vaccine3.isPresent())
				System.out.println(vaccine3.get());
			vaccine3.orElse(new CoronaVaccine());
			Optional<CoronaVaccine> vaccine4 = service.fetchVaccineById(13L);
			if(vaccine4.isPresent())
				System.out.println(vaccine4.get());
			vaccine4.orElseGet(()-> new CoronaVaccine());
		}catch(DataAccessException dae) {
			dae.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
