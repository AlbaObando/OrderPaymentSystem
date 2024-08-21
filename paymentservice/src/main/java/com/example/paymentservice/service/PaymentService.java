package com.example.paymentservice.service;

import com.example.paymentservice.dto.OrderDto;
import com.example.paymentservice.dto.PaymentRequestDto;
import com.example.paymentservice.dto.PaymentResponseDto;
import com.example.paymentservice.entity.Payment;
import com.example.paymentservice.exception.OrderNotFoundException;
import com.example.paymentservice.exception.PaymentProcessingException;
import com.example.paymentservice.proxy.OrderServiceClient;
import com.example.paymentservice.repository.PaymentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentService {

    private final OrderServiceClient orderServiceClient; // Feign client for interacting with the Order Service
    private final PaymentRepository paymentRepository; // Repository for accessing Payment data

    @Autowired
    public PaymentService(OrderServiceClient orderServiceClient, PaymentRepository paymentRepository) {
        this.orderServiceClient = orderServiceClient; // Injecting OrderServiceClient dependency
        this.paymentRepository = paymentRepository; // Injecting PaymentRepository dependency
    }

    /**
     * Processes a payment for a given order.
     *
     * This method validates the payment amount and customer ID against the order details.
     * If the validations pass, it creates a payment record and saves it to the database.
     * The method is transactional, ensuring that all database operations succeed or fail together.
     *
     * @param paymentRequestDto the DTO containing payment details
     * @return PaymentResponseDto containing the payment ID and a success message
     * @throws PaymentProcessingException if validation fails or any issue occurs during payment processing
     */
    @Transactional
    public PaymentResponseDto processPayment(PaymentRequestDto paymentRequestDto) {
        // Retrieve the order using the provided order ID
        OrderDto order = getOrderById(paymentRequestDto.getOrderId());

        // Validate that the payment amount matches the total price of the order
        if (Double.compare(paymentRequestDto.getAmount(), order.getTotalPrice()) != 0) {
            throw new PaymentProcessingException("The payment amount does not match the total price of the order.");
        }

        // Validate that the customer ID matches the one associated with the order
        if (!paymentRequestDto.getCustomerId().equals(order.getCustomerId())) {
            throw new PaymentProcessingException("The customer ID does not match the order.");
        }

        // Create a new Payment entity and populate its fields
        Payment payment = new Payment();
        payment.setOrderId(paymentRequestDto.getOrderId());
        payment.setAmount(paymentRequestDto.getAmount());
        payment.setPaymentMethod(paymentRequestDto.getPaymentMethod());
        payment.setPaymentStatus("PROCESSED"); // Set payment status as "PROCESSED"
        payment.setTimestamp(LocalDateTime.now()); // Record the current timestamp

        // Save the payment record to the database
        paymentRepository.save(payment);

        // Here, you could update the order status using the OrderServiceClient if needed
        // Example: orderServiceClient.updateOrderStatus(order.getId(), "PAID");

        // Return a response indicating successful payment processing
        return new PaymentResponseDto(payment.getId(), "Payment processed successfully");
    }

    /**
     * Retrieves an order by its ID.
     *
     * This method communicates with the Order Service to fetch order details.
     * If the order is not found, it throws an OrderNotFoundException.
     *
     * @param id the ID of the order
     * @return the OrderDto containing the order details
     * @throws OrderNotFoundException if the order is not found
     */
    public OrderDto getOrderById(Long id) {
        try {
            // Fetch the order from the Order Service using the Feign client
            return orderServiceClient.getOrderById(id);
        } catch (Exception e) {
            // Throw a custom exception if the order is not found
            throw new OrderNotFoundException("Order with ID " + id + " not found.");
        }
    }

    /**
     * Retrieves the payment status for a given payment ID.
     *
     * This method fetches the payment record from the database and returns its status.
     * If the payment is not found, it throws a PaymentProcessingException.
     *
     * @param paymentId the ID of the payment
     * @return PaymentResponseDto containing the payment ID and its status
     * @throws PaymentProcessingException if the payment is not found
     */
    public PaymentResponseDto getPaymentStatus(Long paymentId) {
        // Fetch the payment from the database by ID
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new PaymentProcessingException("Payment with ID " + paymentId + " not found."));

        // Return the payment status in the response
        return new PaymentResponseDto(payment.getId(), "Payment status is " + payment.getPaymentStatus());
    }
}
