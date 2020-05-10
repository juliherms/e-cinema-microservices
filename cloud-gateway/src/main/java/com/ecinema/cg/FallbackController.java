package com.ecinema.cg;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

/**
 * This class responsible to implement fallback to connect microservices
 * @author j.a.vasconcelos
 *
 */
@RestController
public class FallbackController {

	/**
	 * Method responsible to catch errors from ticket microservices
	 * @return
	 */
	@RequestMapping("/ticketFallback")
	public Mono<String> ticketServiceFallBack(){
		return Mono.just("Ticket Service is taking to loong to respond or is down. Please can try again");
	}
	
	/**
	 * Method responsible to catch errors from payment microservices
	 * @return
	 */
	@RequestMapping("/paymentFallback")
	public Mono<String> paymentServiceFallBack(){
		return Mono.just("Payment Service is taking too loong to respond or is down. Please can try again");
	}
}
