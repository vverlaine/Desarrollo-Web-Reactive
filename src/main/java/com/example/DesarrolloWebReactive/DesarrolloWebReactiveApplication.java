package com.example.DesarrolloWebReactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@EnableR2dbcRepositories
@SpringBootApplication
public class DesarrolloWebReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesarrolloWebReactiveApplication.class, args);
	}

}
