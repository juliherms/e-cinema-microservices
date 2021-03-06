package com.ecinema.ts.api.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ecinema.ts.api.common.Payment;
import com.ecinema.ts.api.common.TransactionRequest;
import com.ecinema.ts.api.common.TransactionResponse;
import com.ecinema.ts.api.repository.TicketRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Class responsible to provide business logic for Ticket
 * @author j.a.vasconcelos
 *
 */
@Service
@RefreshScope
public class TicketService {

	@Autowired
	private TicketRepository repository;
	
	@Autowired
	@Lazy
	private RestTemplate template;
	
	@Value("${microservice.payment-service.endpoints.endpoint.uri}")
	private String ENDPOINT_URL;
	
	private Logger log = LoggerFactory.getLogger(TicketService.class);
	
	/**
	 * This method responsible to save ticket and request payment service 
	 * @param tr
	 * @return transaction response
	 * @throws JsonProcessingException 
	 */
	public TransactionResponse save(TransactionRequest tr) throws JsonProcessingException {
		
		String message = "";
		
		repository.save(tr.getTicket());
		
		Payment payment = tr.getPayment();
		payment.setTicketId(tr.getTicket().getId());
		payment.setAmount(BigDecimal.TEN);
		
		log.info("TicketService request : {}", new ObjectMapper().writeValueAsString(tr));
		
		//rest call
		Payment paymentResponse = template.postForObject(ENDPOINT_URL,payment,Payment.class);
		
		log.info("PaymentService response : {}", new ObjectMapper().writeValueAsString(paymentResponse));
		
		message = paymentResponse.getStatus().equals("success")?"payment processing successful and ticket placed": "there is a failure in payment api, order added to cart";
		
		return new TransactionResponse(tr.getTicket(),paymentResponse.getAmount(),paymentResponse.getTransactionId(),message);
	}
}
