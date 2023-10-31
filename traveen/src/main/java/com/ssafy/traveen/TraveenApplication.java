package com.ssafy.traveen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ssafy"})
public class TraveenApplication {

	public static void main(String[] args) {
		SpringApplication.run(TraveenApplication.class, args);
	}
}
