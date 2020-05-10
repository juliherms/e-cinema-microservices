package com.ecinema.ps.api.entity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecinema.ps.api.entity.Payment;
import com.ecinema.ps.api.service.PaymentService;
import com.ecinema.ts.api.common.TransactionResponse;

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
	 */
	@ApiOperation(value= "API responsible to create payment")
	@PostMapping("/doPayment")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Return for create payment", response = Payment.class)})
	public Payment doPayment(@RequestBody Payment payment) {
		
		return service.doPayment(payment);
	}
	
	/**
	 * method responsible to return payment for ticket id
	 * @param ticketId
	 * @return
	 */
	@GetMapping("/{ticketId}")
	@ApiOperation(value= "API responsible to get payment by ticket id")
	public Payment findPaymentHistoryByTicketId(@PathVariable long ticketId) {
		
		return service.findPaymentHistoryByTicketId(ticketId);
		
	}
}
