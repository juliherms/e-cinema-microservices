package com.ecinema.ts.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecinema.ts.api.common.Payment;
import com.ecinema.ts.api.common.TransactionRequest;
import com.ecinema.ts.api.common.TransactionResponse;
import com.ecinema.ts.api.service.TicketService;

/**
 * This class represents endpoint ticket
 * @author j.a.vasconcelos
 *
 */
@RestController
@RequestMapping("/tickets")
public class TicketController {

	@Autowired
	private TicketService service;
	
	/**
	 * Reponsible to book ticket in the system
	 * @param ticket
	 * @return
	 */
	@PostMapping("/bookTicket")
	public TransactionResponse bookTicket(@RequestBody TransactionRequest tr) {
		
		return service.save(tr);
	}
	
}
