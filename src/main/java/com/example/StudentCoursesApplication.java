package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com"})
@EntityScan("com.example.model")
@EnableJpaRepositories("com")
@SpringBootApplication
public class StudentCoursesApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentCoursesApplication.class, args);
	}

}
