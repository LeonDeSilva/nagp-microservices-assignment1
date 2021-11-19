package com.leondesilva.msassignment1.servicesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Class to represent the main application
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ServicesServiceApplication {
	/**
	 * Main method
	 *
	 * @param args Arguments to the main application
	 */
	public static void main(String[] args) {
		SpringApplication.run(ServicesServiceApplication.class, args);
	}
}
