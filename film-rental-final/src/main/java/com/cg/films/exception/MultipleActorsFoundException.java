package com.cg.films.exception;
 
@SuppressWarnings("serial")
public class MultipleActorsFoundException extends RuntimeException {
 
	public MultipleActorsFoundException(String message) {
        	super(message);
	}
 
 
}