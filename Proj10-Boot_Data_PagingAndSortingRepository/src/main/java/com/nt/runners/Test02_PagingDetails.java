package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.nt.service.ICoronaVaccineMgmtService;

//@Component
//@Order(2)
public class Test02_PagingDetails implements CommandLineRunner {

	@Autowired
	private ICoronaVaccineMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			service.fetchDetailsByPageNo(0, 2, true, "price", "name").forEach(System.out::println);
		}catch (DataAccessException dae) {
			dae.printStackTrace();
		}
	}
}
