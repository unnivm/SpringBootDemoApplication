package com.istvan.spring.demo.SpringDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableWebSecurity
public class TourDemoApplication {

	public static void main(String[] args) {
		//john12
		String pwd = new BCryptPasswordEncoder().encode("john12");
		System.out.println(pwd);
		SpringApplication.run(TourDemoApplication.class, args);
	}
}
