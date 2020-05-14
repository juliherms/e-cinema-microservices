package com.ecinema.ps.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecinema.ps.api.entity.Product;

/**
 * Class responsible to provide access to database
 * @author j.a.vasconcelos
 *
 */

public interface ProductRepository extends JpaRepository<Product, Long> {

}
