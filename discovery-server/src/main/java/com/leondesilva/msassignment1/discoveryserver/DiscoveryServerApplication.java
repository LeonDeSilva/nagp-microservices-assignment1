package com.leondesilva.msassignment1.discoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Class for discovery service application.
 */
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerApplication {
	/**
	 * Main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServerApplication.class, args);
	}

}
