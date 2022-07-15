package com.nt.runner;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.service.IPersonMgmtService;

//@Component
public class Test01_SaveOperation implements CommandLineRunner {

	@Autowired
	private IPersonMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		//save operation parent to child
		PhoneNumber ph1 = new PhoneNumber(1029299332L, "Vodafone", "Prepaid");
		PhoneNumber ph2 = new PhoneNumber(1023239332L, "JIO", "Prepaid");
		
		Person per1 = new Person("Rajesh", "Hyd");
		
		per1.setContactDetails(Set.of(ph1, ph2));
		
		System.out.println(service.savePerson(per1));
		

		//save operation from child to parent
		PhoneNumber ph3 = new PhoneNumber(1029234332L, "Airtel", "Prepaid");
		PhoneNumber ph4 = new PhoneNumber(1011122332L, "JIO", "Prepaid");
		
		Person per2 = new Person("Karan", "Pune");
		
		ph3.setPerson(per2); ph4.setPerson(per2);
		
		Set<PhoneNumber> phoneSet = Set.of(ph3,ph4);
		per2.setContactDetails(phoneSet);
		System.out.println(service.savePhoneNumbers(phoneSet));
		
	}

}
