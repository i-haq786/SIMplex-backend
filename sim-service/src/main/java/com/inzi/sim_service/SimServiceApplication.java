package com.inzi.sim_service;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SimServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimServiceApplication.class, args);
	}
	
	@Bean
	ModelMapper modelMapper(){
		return  new ModelMapper();
	}
}
