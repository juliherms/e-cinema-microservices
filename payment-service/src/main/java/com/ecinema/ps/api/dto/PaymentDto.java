package com.ecinema.ps.api.dto;

import java.math.BigDecimal;

import com.ecinema.ps.api.entity.Payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for payment
 * @author j.a.vasconcelos
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {

	private long id;
	private String status;
	private String transactionId;
	private long ticketId;
	private BigDecimal amount;
	
	public PaymentDto(Payment p) {
		this(p.getId(), p.getStatus(), p.getTransactionId(), p.getTicketId(), p.getAmount());
	}
	
}


