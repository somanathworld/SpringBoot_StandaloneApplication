package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IPersonMgmtService;

@Component
public class Test04_JoinOperation implements CommandLineRunner{

	@Autowired
	private IPersonMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		service.getDataByJoinsUsingParent().forEach(data->{
			for(Object val : data) {
				System.out.print(val+" ");
			}
			System.out.println();
		});
	}
	
}
