package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.nt.service.ICoronaVaccineMgmtService;

@Component
@Order(3)
public class Test03_PagingDetailsPageWise implements CommandLineRunner {

	@Autowired
	private ICoronaVaccineMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			service.fetchDetailsByPagination(3);
		}catch (DataAccessException dae) {
			dae.printStackTrace();
		}
	}
}
