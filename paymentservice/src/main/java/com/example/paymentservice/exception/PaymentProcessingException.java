package com.example.paymentservice.exception;

/**
 * Custom exception thrown when there is an issue with processing a payment.
 * This exception is used to indicate problems that occur during payment processing,
 * such as validation errors or processing failures.
 */
public class PaymentProcessingException extends RuntimeException {

    /**
     * Constructs a new PaymentProcessingException with the specified detail message.
     *
     * @param message the detail message that describes the reason for the exception
     */
    public PaymentProcessingException(String message) {
        super(message);
    }
}



