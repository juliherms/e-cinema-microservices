package com.ecinema.ts.api.service;

import java.math.BigDecimal;

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
	
	/**
	 * This method responsible to save ticket and request payment service 
	 * @param tr
	 * @return transaction response
	 */
	public TransactionResponse save(TransactionRequest tr) {
		
		String message = "";
		
		repository.save(tr.getTicket());
		
		Payment payment = tr.getPayment();
		payment.setTicketId(tr.getTicket().getId());
		payment.setAmount(BigDecimal.TEN);
		
		//rest call
		Payment paymentResponse = template.postForObject(ENDPOINT_URL,payment,Payment.class);
		
		message = paymentResponse.getStatus().equals("success")?"payment processing successful and ticket placed": "there is a failure in payment api, order added to cart";
		
		return new TransactionResponse(tr.getTicket(),paymentResponse.getAmount(),paymentResponse.getTransactionId(),message);
	}
}
