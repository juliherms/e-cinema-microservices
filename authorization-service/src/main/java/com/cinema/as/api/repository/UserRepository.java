package com.cinema.as.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.as.api.entity.User;

/**
 * Class responsible to access users
 * @author j.a.vasconcelos
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * Method responsible to find user by name.
	 * @param name
	 * @return
	 */
	Optional<User> findByName(String name);

}

