package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.beans.EmployeeInfoProperties;
import com.nt.beans.EmployeeInfoYml;

@SpringBootApplication
public class Proj07BootStaticValueInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Proj07BootStaticValueInjectionApplication.class, args);
//		BillGenerator generator = ctx.getBean("bill", BillGenerator.class);
//		System.out.println(generator.toString());
		
//		CompanyDetails details = ctx.getBean("company", CompanyDetails.class);
//		System.out.println(details);
		
//		CompanyDeatilsValue details = ctx.getBean("companyV", CompanyDeatilsValue.class);
//		System.out.println(details);

		EmployeeInfoProperties info = ctx.getBean("empProps", EmployeeInfoProperties.class);
		System.out.println(info);

//		EmployeeInfoYml info = ctx.getBean("empYml", EmployeeInfoYml.class);
//		System.out.println(info);
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
