package com.ecinema.ps.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecinema.ps.api.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
