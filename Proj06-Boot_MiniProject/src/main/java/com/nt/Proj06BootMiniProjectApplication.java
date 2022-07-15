package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.controller.MainController;

@SpringBootApplication
public class Proj06BootMiniProjectApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Proj06BootMiniProjectApplication.class, args);
		MainController controller = ctx.getBean("controller", MainController.class);
		try {
			controller.displayEmpsByDesgs(new String[] { "CLERK", "SALESMAN" })
			.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error in Code");
		}
	}

}
