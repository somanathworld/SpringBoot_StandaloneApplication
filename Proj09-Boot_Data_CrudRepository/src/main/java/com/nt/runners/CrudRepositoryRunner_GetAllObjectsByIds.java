package com.nt.runners;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.nt.entity.CoronaVaccine;
import com.nt.service.ICoronaVaccineMgmtService;

//@Component
//@Order(6)
public class CrudRepositoryRunner_GetAllObjectsByIds implements CommandLineRunner{

	@Autowired
	private ICoronaVaccineMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		
		try {
			System.out.println("=====simple approach=======");
			Iterable<CoronaVaccine> vaccines1 = service.fetchAllDetailsById(Arrays.asList(3L,4L,5L,12L));
			vaccines1.forEach(vaccine -> {System.out.println(vaccine);});
			System.out.println("=====improved approach=======");
			Iterable<CoronaVaccine> vaccines2 = service.fetchAllDetailsById(Arrays.asList(3L,4L,5L,12L));
			vaccines2.forEach(vaccine -> System.out.println(vaccine));
			System.out.println("=====method ref approach=======");
			Iterable<CoronaVaccine> vaccines3 = service.fetchAllDetailsById(Arrays.asList(3L,4L,5L,12L));
			vaccines3.forEach( System.out::println);
			System.out.println("=====stream api approach=======");
			Iterable<CoronaVaccine> vaccines4 = service.fetchAllDetailsById(Arrays.asList(3L,4L,5L,12L));
			Arrays.asList(vaccines4).stream().forEach(System.out::println);
			System.out.println("=====stream api wtih map approach=======");
			Iterable<CoronaVaccine> vaccines5 = service.fetchAllDetailsById(Arrays.asList(3L,4L,5L,12L));
			Arrays.asList(vaccines5).stream().map(vaccine->vaccine).forEach(System.out::println);
		}catch(DataAccessException dae) {
			dae.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
