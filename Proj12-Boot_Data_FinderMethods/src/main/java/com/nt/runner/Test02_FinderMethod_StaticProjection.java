package com.nt.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.nt.service.ICoronaVaccineMgmtService;
import com.nt.type.ResultView;

//@Component
//@Order(2)
public class Test02_FinderMethod_StaticProjection implements CommandLineRunner{

	@Autowired
	private ICoronaVaccineMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		service.fetchVaccineByPriceAscOrder(700).forEach(e->System.out.println(e.getName() + " " + e.getCountry()));
		List<ResultView> view = service.fetchVaccineByPriceAscOrder(700);
		view.forEach(vaccine->{
			System.out.println(vaccine.getClass()+" "+Arrays.toString(vaccine.getClass().getDeclaredMethods()));
			System.out.println(vaccine.getName()+" "+vaccine.getCountry());
		});		
	}
}
