package com.cg.films.dto;

public class FilmDTO {
	private String title;
	private String description;
	private int releaseYear;
 
	
 
	public FilmDTO(String title, String description, Integer releaseYear) {
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
	}
	
 
	public String getDescription() {
		return description;
	}
 
 
	public void setDescription(String description) {
		this.description = description;
	}
 
 
	public int getReleaseYear() {
		return releaseYear;
	}
 
 
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
 
 
	public String getTitle() {
		return title;
	}
 
	public void setTitle(String title) {
		this.title = title;
	}
	
	
 
}