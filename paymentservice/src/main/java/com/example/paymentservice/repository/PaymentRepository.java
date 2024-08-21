package com.example.paymentservice.repository;

import com.example.paymentservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for performing CRUD operations on Payment entities.
 * Extends JpaRepository to provide a range of built-in database operations.
 */
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // JpaRepository provides methods like save(), findById(), findAll(), deleteById(), etc.
}
