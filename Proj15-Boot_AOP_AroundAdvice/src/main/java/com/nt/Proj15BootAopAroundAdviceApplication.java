package com.nt;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.service.ShoppingStore;

@SpringBootApplication
public class Proj15BootAopAroundAdviceApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Proj15BootAopAroundAdviceApplication.class, args);
		ShoppingStore service = ctx.getBean("shoppingStore", ShoppingStore.class);
		System.out.println("Proxy class : "+service.getClass()+" "+service.getClass().getSuperclass());
		System.out.println(service.calcBillAmount(0.0, 0.0));
		((ConfigurableApplicationContext) ctx).close();
	}

}
