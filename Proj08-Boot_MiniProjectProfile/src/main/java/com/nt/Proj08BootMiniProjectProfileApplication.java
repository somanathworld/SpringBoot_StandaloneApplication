package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.controller.MainController;

@SpringBootApplication
public class Proj08BootMiniProjectProfileApplication {

	public static void main(String[] args) throws Exception{
		ApplicationContext ctx = SpringApplication.run(Proj08BootMiniProjectProfileApplication.class, args);
		MainController contr = ctx.getBean("mainController", MainController.class);
		contr.showEmpsByDesgs(new String[]{"SALESMAN", "CLERK"}).forEach(System.out::println);;
	}

}
