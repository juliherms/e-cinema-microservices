package com.ecinema.ts.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecinema.ts.api.entity.Ticket;

/**
 * This class represents ticket repository
 * @author j.a.vasconcelos
 *
 */
public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
