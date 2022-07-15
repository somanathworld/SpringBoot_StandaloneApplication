package com.nt;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.comp.WishMessageGenerator;

@SpringBootApplication
public class Proj06BootDependencyInjectionApplication {
	
	
	@Bean("ldt")
	public LocalDateTime createLocalDateTimeObject() {
		return LocalDateTime.now();
	}

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Proj06BootDependencyInjectionApplication.class, args);
		WishMessageGenerator wmg = ctx.getBean("wmg", WishMessageGenerator.class);
		System.out.println("Result : "+wmg.generateWishMessage("Raja"));
		((ConfigurableApplicationContext) ctx).close();
	}

}
