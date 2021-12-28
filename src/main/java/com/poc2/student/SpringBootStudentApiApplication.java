package com.poc2.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class SpringBootStudentApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStudentApiApplication.class, args);
	}

}
