package com.example.orderservice.repository;

import com.example.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for accessing {@link Order} entities.
 * <p>
 * This interface extends JpaRepository, providing standard CRUD operations
 * and query methods for the Order entity.
 * </p>
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // No additional methods are required as JpaRepository provides the necessary CRUD operations
}

