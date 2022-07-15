package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Person;
import com.nt.service.IPersonMgmtService;

//@Component
public class Test03_SelectOperation implements CommandLineRunner{

	@Autowired
	private IPersonMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
	
//		service.fetchByPerson().forEach(per->{
//			System.out.println("Person : "+per);
//			Set<PhoneNumber> set = per.getContactDetails();
//			set.forEach(System.out::println);
//		});
		
		service.fetchByPhoneNumber().forEach(phone->{
			System.out.println("Phone: "+phone);
			Person per = phone.getPerson();
			System.out.println("Person : "+per);
		});
	}
	
}
