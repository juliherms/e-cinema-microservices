package com.ecinema.ps.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecinema.ps.api.dto.ProductDto;
import com.ecinema.ps.api.entity.Product;
import com.ecinema.ps.api.service.ProductService;

import io.swagger.annotations.Api;

/**
 * responsible to provider products endpoint
 * 
 * @author j.a.vasconcelos
 *
 */
@RestController
@RequestMapping("products")
@Api(tags = "/products", value = "APi's responsible to product manipulation")
public class ProductController {

	@Autowired
	private ProductService service;

	/**
	 * List all products
	 * @return
	 */
	@GetMapping("/list")
	public List<Product> list() {
		return service.findAll();
	}
	
	/**
	 * List all products paginated
	 * 
	 * @param page
	 * @param count
	 * @return
	 */
	@GetMapping
	public Page<ProductDto> list(
			@PageableDefault(page = 0, size = 10, sort = "name", direction = Direction.ASC) Pageable pageable) {

		Page<Product> products = service.findAll(pageable);

		return ProductDto.converter(products);
	}

	
	/**
	 * Return product by id
	 * @param id
	 * @return
	 */
	@GetMapping("/view/{id}")
	public Product details(@PathVariable Long id) {
		return service.findByid(id);
	}
}
