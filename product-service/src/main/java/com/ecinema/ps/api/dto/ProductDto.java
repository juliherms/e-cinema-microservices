package com.ecinema.ps.api.dto;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;

import com.ecinema.ps.api.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * this class represents DTO Product . Responsible to transfer objects.
 * @author j.a.vasconcelos
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
	
	private Long id;
	private String name;
	private BigDecimal price;
	
	public ProductDto(Product p) {
		this(p.getId(), p.getName(), p.getPrice());
	}
	
	/**
	 * Convert products to DTO
	 * 
	 * @param users
	 * @return
	 */
	public static Page<ProductDto> converter(Page<Product> products) {

		return products.map(ProductDto::new);
	}

}
