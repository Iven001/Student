package com.SpringBoot.Student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/*@ComponentScan(basePackages = {"com.baeldung.dependency.exception"})*/
@EnableJpaRepositories("com.SpringBoot.Student.dao") 
@EntityScan("com.SpringBoot.Student.model")
@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

}
