package com.cg.films.exception;


@SuppressWarnings("serial")
public class InvalidLanguageFoundException extends RuntimeException {
 
	 public InvalidLanguageFoundException(String language) {
	        super("Invalid language: " + language + ". Please check the spelling or try a different language.");
	 }
 
}