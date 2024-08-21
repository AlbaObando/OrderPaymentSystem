package com.example.paymentservice.dto;

import lombok.Data;

/**
 * Data Transfer Object (DTO) for payment responses.
 * This DTO is used to encapsulate the response details after processing a payment.
 */
@Data
public class PaymentResponseDto {

    private Long paymentId;  // The unique identifier of the processed payment
    private String message; // A message indicating the result or status of the payment processing

    /**
     * Parameterized constructor.
     * Initializes a new instance of PaymentResponseDto with specified values for paymentId and message.
     *
     * @param paymentId the unique identifier of the payment
     * @param message a message indicating the result or status of the payment processing
     */
    public PaymentResponseDto(Long paymentId, String message) {
        this.paymentId = paymentId;
        this.message = message;
    }
}

