package com.nt.service;

import org.springframework.stereotype.Service;

@Service("carSR")
public class CarShowRoom {

	public String sellCar(String custName, String carModel, double price) {
		System.out.println("CarShowRoom.sellCar()");
		if(carModel.equalsIgnoreCase("baleano")) {
			return "Car "+carModel+" is sold at price :: "+price+" to customer :: "+custName;
		}else {
			return "Car "+carModel+ " is not available.";
		}
	}
}
