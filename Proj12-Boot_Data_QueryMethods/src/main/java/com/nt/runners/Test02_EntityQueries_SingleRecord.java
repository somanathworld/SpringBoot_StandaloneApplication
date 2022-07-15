package com.nt.runners;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.CoronaVaccine;
import com.nt.service.ICoronaVaccineMgmtService;

//@Component
public class Test02_EntityQueries_SingleRecord implements CommandLineRunner{

	@Autowired
	private ICoronaVaccineMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
//		Optional<CoronaVaccine> opt = service.fetchVaccineByName("pyzer");
//		if(opt.isPresent()) {
//			System.out.println(opt.get());
//		}else {
//			System.out.println("Record not found. ");
//		}
		
//		System.out.println("------------------------------");
//		Object obj = service.fetchVaccineDataByName("pyzer");
//		Object[] details = (Object[])obj;
//		for(Object value : details){
//			System.out.print(value + " ");
//		}

		System.out.println("------------------------------");
		String data = service.fetchVaccineCountryByName("pyzer");
		System.out.println(data);
	}
}
