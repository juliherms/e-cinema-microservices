package com.ecinema.ps.api.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents payment in the system
 * @author j.a.vasconcelos
 *
 */
@Entity
@Table(name="TB_PAYMENT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

	@Id
	@GeneratedValue
	private long id;
	
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
