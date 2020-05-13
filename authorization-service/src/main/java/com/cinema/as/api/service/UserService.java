package com.cinema.as.api.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cinema.as.api.entity.User;
import com.cinema.as.api.repository.UserRepository;

import lombok.AllArgsConstructor;

/**
 * This class provider business logic from user in the system
 * @author j.a.vasconcelos
 *
 */
@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

	private UserRepository userRepository;
	private PasswordEncoder encoder;

	/**
	 * Method responsible to find user by username
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByName(username);
		return user.orElseThrow(() -> new UsernameNotFoundException("user not found: " + username));
	}

	/**
	 * Method responsible to save user.
	 * @param user
	 * @return
	 */
	public User save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

}

