package com.ecinema.ps.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ecinema.ps.api.entity.Payment;

/**
 * Class responsible to provide access to database
 * @author j.a.vasconcelos
 *
 */
public interface PaymentRepository extends MongoRepository<Payment, String> {

	/**
	 * Return payment by ticket id.
	 * @param ticketId
	 * @return
	 */
	Payment findByTicketId(String ticketId);
}
