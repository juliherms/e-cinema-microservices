package com.ecinema.ps.api.service;

import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecinema.ps.api.entity.Payment;
import com.ecinema.ps.api.exception.ResourceNotFoundException;
import com.ecinema.ps.api.repository.PaymentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Class responsible to business service for Payments
 * @author j.a.vasconcelos
 *
 */
@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository repository;
	
	private Logger log = LoggerFactory.getLogger(PaymentService.class);
	
	/**
	 * Method to execute payment
	 * @param payment
	 * @return
	 * @throws JsonProcessingException 
	 */
	public Payment doPayment(Payment payment) throws JsonProcessingException {
		payment.setId(UUID.randomUUID().toString());
		payment.setStatus(paymentProcessing());
		payment.setTransactionId(UUID.randomUUID().toString());
		
		log.info("Payment doPayment request : {}", new ObjectMapper().writeValueAsString(payment));
		
		return repository.save(payment);
	}
	

	/**
	 * Check payment status, integrated external apis.
	 * @return
	 */
	public String paymentProcessing() {
		//api should be 3rd party payment gateway(paypal,paytm...)
		return new Random().nextBoolean()?"success":"false";
	}
	
	/**
	 * Responsible to return payment by informs ticket id.
	 * @param ticketId
	 * @return
	 * @throws JsonProcessingException 
	 */
	public Payment findPaymentHistoryByTicketId(String ticketId) throws JsonProcessingException {
	
		Payment payment = repository.findByTicketId(ticketId);
		log.info("Payment findPaymentHistoryByTicketId : {}", new ObjectMapper().writeValueAsString(payment));
		
		return payment;
	}
	
	/**
	 * Responsible to cancel payment. 
	 * @param id
	 * @return
	 * @throws JsonProcessingException 
	 */
	public Payment cancel(String id) throws JsonProcessingException {
		
		Payment payment = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException());
		payment.setStatus("canceled");
		repository.save(payment);
		
		log.info("Payment cancel : {}", new ObjectMapper().writeValueAsString(payment));
		
		return payment;
	}
}


