package com.nt.comp;

import java.util.Random;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("bd")
@Lazy
public class BlueDart implements Courier{
	
	public BlueDart() {
		System.out.println("BlueDart :: 0-param construcotr.");
	}

	@Override
	public String delivered(String[] items, float[] prices) {
		float amount = 0F;
		for(float p : prices) {
			amount = amount + p;
		}
		int oid = new Random().nextInt(100000);
		return oid+" delivered successfully, and ruppess "+amount+" collected.";
	}
}
