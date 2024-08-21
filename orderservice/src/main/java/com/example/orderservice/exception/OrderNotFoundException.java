package com.example.orderservice.exception;

/**
 * Custom exception thrown when an order is not found.
 */
public class OrderNotFoundException extends RuntimeException {

    /**
     * Constructs a new OrderNotFoundException with the specified detail message.
     *
     * @param message The detail message which is saved for later retrieval by the {@link #getMessage()} method.
     */
    public OrderNotFoundException(String message) {
        super(message);
    }
}
