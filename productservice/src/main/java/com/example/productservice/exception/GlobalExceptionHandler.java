package com.example.productservice.exception;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for managing application-wide exceptions.
 *
 * This class is responsible for intercepting and handling exceptions thrown by the application,
 * providing a consistent response structure for different types of errors.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles ProductNotFoundException thrown when a product is not found.
     *
     * @param ex The exception instance containing details about the error.
     * @return ResponseEntity with a 404 Not Found status and the exception message.
     */
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * Handles FeignException thrown when there is an error communicating with an external API.
     *
     * @param ex The exception instance containing details about the Feign error.
     * @return ResponseEntity with a 503 Service Unavailable status and a generic error message.
     */
    @ExceptionHandler(FeignException.class)
    public ResponseEntity<String> handleFeignException(FeignException ex) {
        return new ResponseEntity<>("Error communicating with external API: " + ex.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
    }

    /**
     * Handles any other unforeseen exceptions that are not specifically handled.
     *
     * @param ex The exception instance containing details about the error.
     * @return ResponseEntity with a 500 Internal Server Error status and a generic error message.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
