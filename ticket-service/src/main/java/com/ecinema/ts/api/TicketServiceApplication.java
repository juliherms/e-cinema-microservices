package com.ecinema.ts.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Tecket microservice responsible to provide tickets for cine
 * Connect to Eureka Server - Service Discovery
 * @author j.a.vasconcelos
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class TicketServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketServiceApplication.class, args);
	}
	
	/**
	 * Inject rest template responsible to call another services
	 * @return
	 */
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
