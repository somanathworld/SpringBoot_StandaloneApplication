package com.nt.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.comp.Flipkart;

public class MainTest {
	
	@Test
	public void TestMain() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/config/applicationContext.xml");
		Flipkart fp = ctx.getBean("fkart", Flipkart.class);
		assertNotNull(fp.shop(new String[] {"Shirt","Pants"}, new float[]{1200.0F,1500.0F}));
	}

}
