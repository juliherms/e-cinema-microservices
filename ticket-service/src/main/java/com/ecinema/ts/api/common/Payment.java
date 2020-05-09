package com.ecinema.ts.api.common;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for Payment
 * @author j.a.vasconcelos
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

	private long id;
	private String status;
	private String transactionId;
	private long ticketId;
	private BigDecimal amount;

}
