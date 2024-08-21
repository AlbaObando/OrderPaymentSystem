package com.example.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Main class for the Product Service application.
 *
 * This is the entry point of the Spring Boot application. It is responsible for bootstrapping
 * the application context and starting the Spring Boot application.
 */
@SpringBootApplication
@EnableFeignClients  // Enables support for Feign clients in the application
public class ProductserviceApplication {

	/**
	 * Main method for running the Spring Boot application.
	 *
	 * @param args Command-line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(ProductserviceApplication.class, args);  // Launches the application
	}

}

