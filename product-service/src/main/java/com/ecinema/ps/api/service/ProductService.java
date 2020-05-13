package com.ecinema.ps.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecinema.ps.api.entity.Product;
import com.ecinema.ps.api.exception.ResourceNotFoundException;
import com.ecinema.ps.api.repository.ProductRepository;

/**
 * Class responsible to business logic for product
 * @author j.a.vasconcelos
 *
 */
@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;

	/**
	 * method responsible to list all products
	 * 
	 * @return
	 */
	public List<Product> findAll() {

		return repo.findAll();
	}

	/**
	 * method responsible to find product by id.
	 * @param id
	 * @return
	 */
	public Product findByid(Long id) {

		Product product = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException());

		return product;
	}
}
