package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.nt.service.ICoronaVaccineMgmtService;
import com.nt.type.ResultView;
import com.nt.type.ResultView1;
import com.nt.type.ResultView2;
import com.nt.type.ResultView3;

@Component
@Order(3)
public class Test03_FinderMethod_DynamicProjection implements CommandLineRunner{

	@Autowired
	private ICoronaVaccineMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("--------ResultView1------------");
		service
		.searchVaccineByCompany("Pyzer", ResultView1.class)
		.forEach(vaccine -> {
			System.out.println(vaccine.getName()+ " "+ vaccine.getCompany());
		});

		System.out.println("--------ResultView2------------");
		service
		.searchVaccineByCompany("Pyzer", ResultView2.class)
		.forEach(vaccine -> {
			System.out.println(vaccine.getRegNo()+ " "+vaccine.getPrice()+" "+vaccine.getCompany());
		});

		System.out.println("--------ResultView3------------");
		service
		.searchVaccineByCompany("Pyzer", ResultView3.class)
		.forEach(vaccine -> {
			System.out.println(vaccine.getPrice());
		});
	}
	
}
