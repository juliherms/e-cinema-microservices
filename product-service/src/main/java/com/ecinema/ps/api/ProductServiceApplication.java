package com.ecinema.ps.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

/**
 * Microservice responsible to provide products
 * @author j.a.vasconcelos
 *
 */
@SpringBootApplication
@EnableSpringDataWebSupport // allows pageable
@EnableEurekaClient
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
	
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		RedisStandaloneConfiguration conf = 
				new RedisStandaloneConfiguration(
							System.getenv("REDIS_HOST"),
							Integer.valueOf(System.getenv("REDIS_HOST"))
						);
		return new JedisConnectionFactory(conf);
	}

}
