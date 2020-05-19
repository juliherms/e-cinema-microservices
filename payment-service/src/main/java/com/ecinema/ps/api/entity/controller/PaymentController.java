package com.ecinema.ps.api.entity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecinema.ps.api.dto.PaymentDto;
import com.ecinema.ps.api.entity.Payment;
import com.ecinema.ps.api.service.PaymentService;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * responsible to provider payments endpoint
 * @author j.a.vasconcelos
 *
 */
@RestController
@RequestMapping("payments")
@Api(tags="/payments", value ="APi's responsible to payment manipulation")
public class PaymentController {

	@Autowired
	private PaymentService service;
	
	/**
	 * method responsible to effect payment
	 * @param payment
	 * @return
	 * @throws JsonProcessingException 
	 */
	@ApiOperation(value= "API responsible to create payment")
	@PostMapping("/doPayment")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Return for create payment", response = Payment.class)})
	public Payment doPayment(@RequestBody Payment payment) throws JsonProcessingException {
		
		return service.doPayment(payment);
	}
	
	/**
	 * method responsible to return payment for ticket id
	 * @param ticketId
	 * @return
	 * @throws JsonProcessingException 
	 */
	@GetMapping("/{ticketId}")
	@ApiOperation(value= "API responsible to get payment by ticket id")
	public PaymentDto findPaymentHistoryByTicketId(@PathVariable String ticketId) throws JsonProcessingException {
		
		return new PaymentDto(service.findPaymentHistoryByTicketId(ticketId));
	}
	
	/**
	 * method responsible to cancel payment
	 * @param id
	 * @return
	 * @throws JsonProcessingException
	 */
	@DeleteMapping("/{id}")
	@ApiOperation(value="API resonsible to cancel payment")
	public PaymentDto cancel(@PathVariable("id") String id) throws JsonProcessingException {
		
		return new PaymentDto(service.cancel(id));
	}

}
