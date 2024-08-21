package com.example.paymentservice.exception;

import lombok.Data;

/**
 * Represents the structure of an error response to be returned to the client.
 * This class encapsulates the HTTP status code and a descriptive error message.
 */
@Data
public class ErrorResponse {
    private int status;      // HTTP status code indicating the type of error
    private String message; // Descriptive error message to provide details about the error

    /**
     * Parameterized constructor.
     * Initializes a new instance of ErrorResponse with specified status code and message.
     *
     * @param status the HTTP status code representing the error
     * @param message a descriptive message explaining the error
     */
    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
