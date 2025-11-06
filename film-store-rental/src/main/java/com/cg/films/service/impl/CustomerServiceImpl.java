package com.cg.films.service.impl;
 
import java.util.List;
import java.util.stream.Collectors;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.cg.films.dto.CustomerNameDTO;
import com.cg.films.dto.CustomerPaymentGroupDTO;
import com.cg.films.dto.PaymentDetailDTO;
import com.cg.films.entity.Customer;
import com.cg.films.entity.Payment;
import com.cg.films.repository.CustomerRepository;
import com.cg.films.repository.PaymentRepository;
import com.cg.films.service.CustomerService;
 
@Service
public class CustomerServiceImpl implements CustomerService {
 
    @Autowired
    private CustomerRepository customerRepository;
 
    @Autowired
    private PaymentRepository paymentRepository;
 
    @Override
    public List<CustomerNameDTO> getAllCustomerNames() {
        return customerRepository.findAll().stream()
            .map(c -> new CustomerNameDTO(c.getFirstName(), c.getLastName()))
            .collect(Collectors.toList());
    }
 
    @Override
    public List<CustomerPaymentGroupDTO> getGroupedPaymentsByCustomerName(String firstName, String lastName) {
        List<Payment> payments = paymentRepository.findByCustomerFirstNameAndCustomerLastName(firstName, lastName);
 
        if (payments.isEmpty()) {
            return List.of();
        }
 
        Customer customer = payments.get(0).getCustomer();
 
        List<PaymentDetailDTO> paymentDetails = payments.stream()
            .map(p -> new PaymentDetailDTO(
                p.getPaymentId(),
                p.getAmount(),
                p.getPaymentDate()
            ))
            .collect(Collectors.toList());
 
        CustomerPaymentGroupDTO grouped = new CustomerPaymentGroupDTO(
            customer.getFirstName(),
            customer.getLastName(),
            paymentDetails
        );
 
        return List.of(grouped);
    }
}