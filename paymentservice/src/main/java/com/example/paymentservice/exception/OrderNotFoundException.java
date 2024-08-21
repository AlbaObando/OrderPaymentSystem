package com.example.paymentservice.exception;

/**
 * Custom exception thrown when an order is not found.
 * This exception is used to indicate that a requested order does not exist in the system.
 */
public class OrderNotFoundException extends RuntimeException {

    /**
     * Constructs a new OrderNotFoundException with the specified detail message.
     *
     * @param message the detail message that describes the reason for the exception
     */
    public OrderNotFoundException(String message) {
        super(message);
    }
}
