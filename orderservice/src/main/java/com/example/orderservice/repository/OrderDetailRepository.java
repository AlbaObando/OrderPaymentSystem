package com.example.orderservice.repository;

import com.example.orderservice.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for accessing {@link OrderDetail} entities.
 */
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    // No additional methods are required as JpaRepository provides the necessary CRUD operations
}
