package com.ecinema.ps.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

/**
 * Microservice responsible to provide products
 * @author j.a.vasconcelos
 *
 */
@SpringBootApplication
@EnableSpringDataWebSupport // allows pageable
@EnableEurekaClient
@EnableCaching //allows cache
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
	
}
