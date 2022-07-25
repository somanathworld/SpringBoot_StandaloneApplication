package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Proj34BootSchedulingCronExpApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proj34BootSchedulingCronExpApplication.class, args);
	}

}
