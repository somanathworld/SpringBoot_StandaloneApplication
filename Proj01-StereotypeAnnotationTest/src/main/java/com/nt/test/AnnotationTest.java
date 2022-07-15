package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.comp.Flipkart;

public class AnnotationTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/config/applicationContext.xml");
		Flipkart fp = ctx.getBean("fkart", Flipkart.class);
		String result = fp.shop(new String[] {"Shirt","Pants"}, new float[]{1200.0F,1500.0F});
		System.out.println(result);
	}
}
