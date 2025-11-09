package com.cg.films.exception;
 
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;
 
@RestControllerAdvice
 
public class FilmRentalGlobalExceptionHandler {
	@ExceptionHandler(value = MultipleActorsFoundException.class)
	public ResponseEntity<String> multipleActorsFoundException(MultipleActorsFoundException ex){
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	

	@ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(Map.of("message", ex.getMessage()));
    }


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleEntityNotFound(EntityNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", ex.getMessage()));
    }
    
    @ExceptionHandler(RecordNotFound.class)
    public ResponseEntity<String> handleFilmNotFound(RecordNotFound ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    
	@ExceptionHandler(PaymentDetailsNotFoundException.class)
    public ResponseEntity<String> handlePaymentDetailsNotFound(PaymentDetailsNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
	
	@ExceptionHandler(value=NoFilmsFoundForLanguageException.class)
	public ResponseEntity<String> noFilmsFoundForLanguageException(NoFilmsFoundForLanguageException ex)
	{
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
    }
	@ExceptionHandler(value=InvalidLanguageFoundException.class)
	public ResponseEntity<String> invalidLanguageFoundException(InvalidLanguageFoundException ex)
	{
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(value = InvalidActorNameException.class)
	public ResponseEntity<String> handleInvalidActorName(InvalidActorNameException ex) {
	    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
    @ExceptionHandler(StaffNotFoundException.class)
    public ResponseEntity<String> handleStaffNotFoundException(StaffNotFoundException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }
    
	 @ExceptionHandler(ManagerIdNotFoundException.class)
	    public ResponseEntity<String> ManagerIdNotFound(ManagerIdNotFoundException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	    }
	 
	 @ExceptionHandler(InvalidInputException.class)
	    public ResponseEntity<String> handleInvalidInput(InvalidInputException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	 

	 @ExceptionHandler(FilmNotFoundException.class)
	 public ResponseEntity<Map<String, String>> handleFilmNotFound(FilmNotFoundException ex) {
	     Map<String, String> error = new HashMap<>();
	     error.put("error", ex.getMessage());
	     return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	 }

}