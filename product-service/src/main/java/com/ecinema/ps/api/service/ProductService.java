package com.ecinema.ps.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	 * method responsible to list all products pageable
	 * @param pageable
	 * @return
	 */
	@Cacheable(cacheNames = Product.CACHE_NAME, key="#root.method.name")
	public Page<Product> findAll(Pageable pageable){
		return repo.findAll(pageable);
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

	/**
	 * method responsible to create products
	 * @param p
	 * @return
	 */
	@CacheEvict(cacheNames = Product.CACHE_NAME, allEntries = true)
    public Product create(Product p) {
        return repo.save(p);
    }
}
