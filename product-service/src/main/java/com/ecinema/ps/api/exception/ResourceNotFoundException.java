package com.ecinema.ps.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This class represents personal exception
 * @author j.a.vasconcelos
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;


}
