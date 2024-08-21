package com.example.productservice.exception;

/**
 * Custom exception thrown when a product is not found.
 *
 * This class extends RuntimeException to represent a specific error condition related to
 * the absence of a product in the system. It is used to provide a clear and meaningful
 * exception type for scenarios where a requested product cannot be found.
 */
public class ProductNotFoundException extends RuntimeException {

    /**
     * Constructor to create an instance of ProductNotFoundException with a specific message.
     *
     * @param message The detail message that describes the reason for the exception.
     */
    public ProductNotFoundException(String message) {
        super(message);  // Passes the message to the superclass (RuntimeException)
    }
}
