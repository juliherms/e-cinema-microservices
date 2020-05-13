package com.ecinema.ts.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecinema.ts.api.common.TransactionRequest;
import com.ecinema.ts.api.common.TransactionResponse;
import com.ecinema.ts.api.service.TicketService;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This class represents endpoint ticket
 * @author j.a.vasconcelos
 *
 */
@RestController
@RequestMapping("/tickets")
@Api(tags="/tickets", value ="APi's responsible to ticket manipulation")
public class TicketController {

	@Autowired
	private TicketService service;
	
	/**
	 * Responsible to book ticket in the system
	 * @param ticket
	 * @return
	 * @throws JsonProcessingException 
	 */
	@ApiOperation(value= "API responsible to create a booked ticket")
	@PostMapping("/bookTicket")
	@ApiResponses(value = {@ApiResponse(code = 201, message = "Return for create ticket", response = TransactionResponse.class)})
	public TransactionResponse bookTicket(@RequestBody TransactionRequest tr) throws JsonProcessingException {
		
		return service.save(tr);
	}
	
}
