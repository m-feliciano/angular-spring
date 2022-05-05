package br.com.feliciano.springangular.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotfound(ObjectNotFoundException e, HttpServletRequest request) {
		StandardError error = 
				new StandardError(System.currentTimeMillis(), 
						HttpStatus.NOT_FOUND.value(), 
						"Not found",
						e.getMessage(), 
						request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

	}

	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardError> dataIntegrity(DataIntegrityException e, HttpServletRequest request) {
		StandardError error = 
				new StandardError(System.currentTimeMillis(), 
						HttpStatus.BAD_REQUEST.value(),
				"Data Integrity", 
						e.getMessage(), 
						request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> dataIntegrity(MethodArgumentNotValidException e, HttpServletRequest request) {
		ValidationError error = 
				new ValidationError(System.currentTimeMillis(), 
						HttpStatus.UNPROCESSABLE_ENTITY.value(),
						"Validation error", 
						e.getMessage(), 
						request.getRequestURI());
		
		e.getBindingResult().getFieldErrors().forEach(f -> error.addError(f.getField(), f.getDefaultMessage()));
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(error);
	}
	
}
