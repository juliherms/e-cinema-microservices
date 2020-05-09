package com.ecinema.ts.api.common;

import com.ecinema.ts.api.entity.Ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for transaction request
 * @author j.a.vasconcelos
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {
	
	private Ticket ticket;
	private Payment payment;

}
