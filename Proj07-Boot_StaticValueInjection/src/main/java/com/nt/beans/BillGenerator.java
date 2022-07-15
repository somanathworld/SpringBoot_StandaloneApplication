package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration("bill")
public class BillGenerator {

	@Value("Paradise")
	private String hotelName;
	@Value("#{items.getDosaPrice() + items.getIdlyPrice() + items.getPohaPrice()}")
	private float total;

	@Override
	public String toString() {
		return "BillGenerator [hotelName=" + hotelName + ", total=" + total + "]";
	}

}
