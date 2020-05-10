package com.ecinema.ps.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Payment microservice responsible to provide payment tickets
 * Connect to Eureka Server - Service Discovery
 * @author j.a.vasconcelos
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class PaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceApplication.class, args);
	}

}
