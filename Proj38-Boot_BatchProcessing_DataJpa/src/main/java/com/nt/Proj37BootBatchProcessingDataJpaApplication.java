package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Proj37BootBatchProcessingDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proj37BootBatchProcessingDataJpaApplication.class, args);
	}

}
