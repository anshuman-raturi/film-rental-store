package com.cg.films.exception;
 
@SuppressWarnings("serial")
public class NoFilmsFoundForLanguageException extends RuntimeException{
	public NoFilmsFoundForLanguageException(String msg) {
		super("Films are not available in the language "+msg+".Please select another language.");
	}
 
}