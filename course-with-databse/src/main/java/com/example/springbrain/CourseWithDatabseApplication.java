package com.example.springbrain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("topic")
@EnableJpaRepositories("topic")
@EntityScan("topic")
public class CourseWithDatabseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseWithDatabseApplication.class, args);
		System.out.print("Hello World!");
	}

}
 