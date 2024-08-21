package com.example.orderservice.exception;

/**
 * Custom exception thrown when a product is not found.
 */
public class ProductNotFoundException extends RuntimeException {

    /**
     * Constructs a new ProductNotFoundException with the specified detail message.
     *
     * @param message The detail message which is saved for later retrieval by the {@link #getMessage()} method.
     */
    public ProductNotFoundException(String message) {
        super(message);
    }
}
