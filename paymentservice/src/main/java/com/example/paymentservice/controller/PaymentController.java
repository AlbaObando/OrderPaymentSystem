package com.example.paymentservice.controller;

import com.example.paymentservice.dto.PaymentRequestDto;
import com.example.paymentservice.dto.PaymentResponseDto;
import com.example.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for handling payment-related requests.
 * Provides endpoints for processing payments and retrieving payment status.
 */
@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    /**
     * Constructor-based injection for PaymentService.
     * This approach is preferred for better testability and immutability.
     *
     * @param paymentService the PaymentService instance
     */
    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    /**
     * Endpoint to process a payment.
     *
     * @param paymentRequestDto the payment request details
     * @return ResponseEntity containing PaymentResponseDto and HTTP status
     */
    @PostMapping("/process")
    public ResponseEntity<PaymentResponseDto> processPayment(@RequestBody PaymentRequestDto paymentRequestDto) {
        PaymentResponseDto paymentResponse = paymentService.processPayment(paymentRequestDto);
        return new ResponseEntity<>(paymentResponse, HttpStatus.OK);
    }

    /**
     * Endpoint to retrieve the status of a payment by its ID.
     *
     * @param paymentId the ID of the payment
     * @return ResponseEntity containing PaymentResponseDto and HTTP status
     */
    @GetMapping("/{paymentId}")
    public ResponseEntity<PaymentResponseDto> getPaymentStatus(@PathVariable Long paymentId) {
        PaymentResponseDto payment = paymentService.getPaymentStatus(paymentId);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }
}
