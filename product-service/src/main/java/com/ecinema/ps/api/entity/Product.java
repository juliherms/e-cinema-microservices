package com.ecinema.ps.api.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents product in the system
 * 
 * @author j.a.vasconcelos
 *
 */
@Entity
@Table(name = "TB_PRODUCT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
	
   public static final String CACHE_NAME = "Product";

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank
	private String name;

	@NotNull
	@Positive
	private BigDecimal price;

}
