package com.nt.runners;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.nt.entity.CoronaVaccine;
import com.nt.service.ICoronaVaccineMgmtService;

@Component
@Order(2)
public class CrudRepositoryRunner_BulkInsert implements CommandLineRunner{

	@Autowired
	private ICoronaVaccineMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		try {
		Iterable<CoronaVaccine> vaccines = 
				service.registerInBatch(
						Arrays.asList(
								new CoronaVaccine("Sputinik", "Russie", "Russia", 600.0, 2),
								new CoronaVaccine("pyzer", "Pyzer", "USA", 800.0, 2),
								new CoronaVaccine("moderena","Moderena", "USA", 750.0, 2)
									)
						);
		System.out.println("The reqNos are :");
		vaccines.forEach(e->System.out.println(e.getRegNo()));
		}catch (DataAccessException dae) {
			dae.printStackTrace();
		}
	}
	
}
