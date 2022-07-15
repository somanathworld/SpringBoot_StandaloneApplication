package com.nt.comp;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("dtdc")
@Lazy
public class DTDC implements Courier{

	@Autowired
	private LocalDateTime dt;
	
	public DTDC() {
		System.out.println("DTDC :: 0-param constructor.");
	}
	@Override
	public String delivered(String[] items, float[] prices) {
		float amount = 0F;
		for(float p : prices) {
			amount = amount + p;
		}
		int oid = new Random().nextInt(100000);
		return oid+" delivered successfully, and ruppess "+amount+" collected at "+dt+".";
	}
}
