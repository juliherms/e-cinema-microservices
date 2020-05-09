package com.ecinema.ts.api.common;

import java.math.BigDecimal;

import com.ecinema.ts.api.entity.Ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {

	private Ticket ticket;
	private BigDecimal amount;
	private String transactionId;
	private String message;
}
