package com.example.demowithspringjpaandpostgre;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoWithSpringJpaAndPostgreApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoWithSpringJpaAndPostgreApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository){
		return args -> {
			Student maria = new Student(
					"Maria",
					"Jones",
					"maria.jones@amigoscode.edu",
					21
			);
			studentRepository.save(maria);
		};
	}
}
