package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.comp.Flipkart;

public class Test100pCode {

	public static void main(String[] args) {
	
		ApplicationContext ctx = new AnnotationConfigApplicationContext(com.nt.config.AppConfig.class);
		Flipkart fkart = ctx.getBean("fkart", Flipkart.class);
		String result = fkart.shop(new String[] {"shirt","pants"}, new float[] {1200.0F, 1300.0F});
		System.out.println(result);
		((AbstractApplicationContext) ctx).close();
		
		
	}
}
