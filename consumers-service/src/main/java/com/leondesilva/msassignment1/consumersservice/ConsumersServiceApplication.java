package com.leondesilva.msassignment1.consumersservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Class to represent the main application
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumersServiceApplication {
	/**
	 * Main method
	 *
	 * @param args Arguments to the main application
	 */
	public static void main(String[] args) {
		SpringApplication.run(ConsumersServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
