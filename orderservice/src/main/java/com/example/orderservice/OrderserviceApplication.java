package com.example.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Main entry point for the Order Service application.
 * <p>
 * This class is annotated with @SpringBootApplication to enable Spring Boot's
 * auto-configuration and component scanning. It also enables Feign clients
 * through the @EnableFeignClients annotation for communicating with other
 * microservices.
 * </p>
 */
@SpringBootApplication
@EnableFeignClients
public class OrderserviceApplication {

	/**
	 * The main method, which is the entry point of the Spring Boot application.
	 *
	 * @param args Command-line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(OrderserviceApplication.class, args);
	}
}

