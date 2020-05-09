package com.ecinema.ts.api.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents ticket in the system
 * @author j.a.vasconcelos
 *
 */
@Entity
@Table(name="TB_TICKET")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
	
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private int qty;
	private BigDecimal price;

}
