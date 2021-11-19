package com.leondesilva.msassignment1.ordersservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Class to represent the main application
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrdersServiceApplication {
	/**
	 * Main method
	 *
	 * @param args Arguments to the main application
	 */
	public static void main(String[] args) {
		SpringApplication.run(OrdersServiceApplication.class, args);
	}
}
