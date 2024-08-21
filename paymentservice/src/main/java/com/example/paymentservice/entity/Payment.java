package com.example.paymentservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Entity class representing a payment record in the database.
 * This class is mapped to the 'payments' table in the database.
 */
@Data
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;              // Unique identifier for the payment record
    private Long orderId;         // The ID of the associated order
    private Double amount;       // The amount of the payment
    private String paymentStatus; // The current status of the payment (e.g., 'SUCCESS', 'FAILED')
    private String paymentMethod; // The method used to make the payment (e.g., 'Credit Card', 'PayPal')
    private LocalDateTime timestamp; // The date and time when the payment was processed

}
