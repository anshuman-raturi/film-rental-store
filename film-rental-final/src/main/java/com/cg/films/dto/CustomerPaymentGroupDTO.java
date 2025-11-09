package com.cg.films.dto;
 
import java.util.List;
 
public class CustomerPaymentGroupDTO {
    private String firstName;
    private String lastName;
    private List<PaymentDetailDTO> payments;
 
    public CustomerPaymentGroupDTO(String firstName, String lastName, List<PaymentDetailDTO> payments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.payments = payments;
    }
 
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public List<PaymentDetailDTO> getPayments() { return payments; }
}