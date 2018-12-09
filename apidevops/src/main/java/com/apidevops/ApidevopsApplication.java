package com.apidevops;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;

@EnableMongoAuditing
@EnableReactiveMongoRepositories
@SpringBootApplication
@EnableWebFluxSecurity
public class ApidevopsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApidevopsApplication.class, args);
	}
}
