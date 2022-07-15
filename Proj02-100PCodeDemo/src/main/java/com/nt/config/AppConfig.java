package com.nt.config;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.nt.comp")
@PropertySource({"com/nt/common/info.properties"})
public class AppConfig {

	@Bean("dt")
	public LocalDateTime createLocalDateTime(){
		System.out.println(LocalDateTime.now());
		return LocalDateTime.now();
	}
}
