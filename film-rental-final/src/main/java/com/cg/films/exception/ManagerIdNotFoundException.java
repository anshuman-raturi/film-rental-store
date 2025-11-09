package com.cg.films.exception;
 
public class ManagerIdNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
 
    public ManagerIdNotFoundException(String message) {
        super(message);
    }
}