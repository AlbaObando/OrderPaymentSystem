package com.example.orderservice.exception;

import lombok.Data;

/**
 * Class representing an error response returned to the client.
 */
@Data
public class ErrorResponse {

    private int status;    // HTTP status code of the error
    private String message; // Detailed message explaining the error

    /**
     * Constructor for creating an ErrorResponse with specified status and message.
     *
     * @param status HTTP status code of the error.
     * @param message Detailed message explaining the error.
     */
    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
