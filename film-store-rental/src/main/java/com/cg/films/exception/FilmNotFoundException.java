package com.cg.films.exception;

public class FilmNotFoundException extends RuntimeException {
    public FilmNotFoundException(String filmName) {
        super("Film not found: " + filmName);
    }
}