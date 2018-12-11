package com.istvan.spring.demo.SpringDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class TourDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TourDemoApplication.class, args);
	}
}
