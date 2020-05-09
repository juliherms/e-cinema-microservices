package com.ecinema.ps.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecinema.ps.api.entity.Payment;

/**
 * Class responsible to provide access to database
 * @author j.a.vasconcelos
 *
 */
public interface PaymentRepository extends JpaRepository<Payment, Long> {

	/**
	 * Return payment by ticket id.
	 * @param ticketId
	 * @return
	 */
	Payment findByTicketId(long ticketId);
}
