package com.ecinema.ps.api.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents payment in the system
 * @author j.a.vasconcelos
 *
 */
@Document(collection = "Payments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

	@Id
	private String id;
	
	@NotBlank
	private String status;
	
	@NotBlank
	private String transactionId;
	
	@Column(nullable=false)
	private long ticketId;
	
	@NotNull 
	@Positive
	private BigDecimal amount;
}
