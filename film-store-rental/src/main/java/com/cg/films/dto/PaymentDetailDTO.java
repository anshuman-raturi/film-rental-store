package com.cg.films.dto;
 
import java.math.BigDecimal;
import java.sql.Timestamp;
 
public class PaymentDetailDTO {
    private Long paymentId;
    private BigDecimal amount;
    private Timestamp paymentDate;
 
    public PaymentDetailDTO(Long paymentId, BigDecimal amount, Timestamp paymentDate) {
      this.paymentId = paymentId;
      this.amount = amount;
      this.paymentDate = paymentDate;	
      }

	public Long getPaymentId() { return paymentId; }
    public BigDecimal getAmount() { return amount; }
    public Timestamp getPaymentDate() { return paymentDate; }
}