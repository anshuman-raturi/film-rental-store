package com.cg.films.dto;
 
public class CustomerNameDTO {
    private String firstName;
    private String lastName;
 
    public CustomerNameDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
 
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
}