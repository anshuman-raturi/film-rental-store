package com.cg.films.exception;
 
@SuppressWarnings("serial")
public class InvalidActorNameException extends RuntimeException {
 
	public InvalidActorNameException(String message) {
        	super(message);
	}
 
}