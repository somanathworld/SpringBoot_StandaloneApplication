package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.comp.Cricket;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/nt/cofig/applicationContext.xml");
		Cricket cat = ctx.getBean("crckt", Cricket.class);
		cat.batting();
		cat.fielding();
		((AbstractApplicationContext) ctx).close();
	}
}
