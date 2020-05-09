package com.ecinema.ps.api.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private String status;
	private String transactionId;
	private long ticketId;
	private BigDecimal amount;
}
