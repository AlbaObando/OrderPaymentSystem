package com.example.paymentservice.dto;

import lombok.Data;

/**
 * Data Transfer Object (DTO) for processing payment requests.
 * This DTO is used to encapsulate the details required to process a payment.
 */
@Data
public class PaymentRequestDto {
    private Long orderId;          // The ID of the order associated with this payment
    private Double amount;        // The amount of money to be paid
    private String paymentMethod; // The method used for the payment (e.g., credit card, PayPal)
    private Long customerId;      // The ID of the customer making the payment

    // Note: Lombok's @Data annotation generates the getters, setters,
    // toString(), equals(), and hashCode() methods automatically.
}
