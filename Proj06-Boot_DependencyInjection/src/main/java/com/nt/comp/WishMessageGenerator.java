package com.nt.comp;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {

	@Autowired
	private LocalDateTime ldt;
	
	public String generateWishMessage(String user) {
		System.out.println("WishMessageGenerator.generateWishMessage()");
		int hours = ldt.getHour();
		
		if(hours < 12)
			return "Good morning : "+user;
		else if (hours < 18)
			return "Good Afternoon : "+user;
		else
			return "Good Evening : "+user;
	}
}
