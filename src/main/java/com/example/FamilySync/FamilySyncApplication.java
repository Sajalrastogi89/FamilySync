package com.example.FamilySync;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class FamilySyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(FamilySyncApplication.class, args);
	}
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
