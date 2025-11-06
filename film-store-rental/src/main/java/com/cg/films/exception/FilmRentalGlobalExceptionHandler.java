package com.cg.films.exception;
 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
 
@RestControllerAdvice
 
public class FilmRentalGlobalExceptionHandler {
	@ExceptionHandler(value = MultipleActorsFoundException.class)
	public ResponseEntity<String> multipleActorsFoundException(MultipleActorsFoundException ex){
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
 
}