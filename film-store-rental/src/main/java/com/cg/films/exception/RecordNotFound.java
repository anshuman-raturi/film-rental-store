package com.cg.films.exception;
 
 
@SuppressWarnings("serial")
public class RecordNotFound extends RuntimeException {
    public RecordNotFound(String message) {
        super(message);
    }
}