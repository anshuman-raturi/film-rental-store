package com.cg.films.exception;
 
public class PaymentDetailsNotFoundException extends RuntimeException {
    public PaymentDetailsNotFoundException(String firstName, String lastName) {
        super("No payment details found for customer: " + firstName + " " + lastName);
    }
}