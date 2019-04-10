package com.school.administration.persist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.school.administration.persist"})
@EntityScan("com.school.administration.persist.domain")
@EnableJpaRepositories("com.school.administration.persist.repository")
public class SchoolAdministrationPersistApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolAdministrationPersistApplication.class, args);
	}

}
