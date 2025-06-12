package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
@SpringBootApplication
public class projectMISApplication {

	public static void main(String[] args) {
		SpringApplication.run(projectMISApplication.class, args);
	}
	@Bean
	OpenAPI springOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Correspondence Service").description("Correspondence MGMT Service API").version("v1.0.0"));
	}
}
