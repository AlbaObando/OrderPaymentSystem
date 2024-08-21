package com.example.orderservice.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entity class representing details of an order.
 */
@Data
@Entity
@Table(name = "order_detail") // Table name in the database
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremented primary key
    private Long id;

    @Column(name = "order_id") // Foreign key to the Order entity
    private Long orderId;

    @Column(name = "product_id") // Foreign key to the Product entity
    private Long productId;

    private Integer quantity; // Quantity of the product in the order

    private Double price; // Price of the product at the time of the order

    /**
     * Default constructor for OrderDetail.
     */
    public OrderDetail() {
    }

    /**
     * Constructor for creating an OrderDetail with specified fields.
     *
     * @param id Unique identifier of the order detail.
     * @param orderId Unique identifier of the associated order.
     * @param productId Unique identifier of the associated product.
     * @param quantity Quantity of the product in the order.
     * @param price Price of the product at the time of the order.
     */
    public OrderDetail(Long id, Long orderId, Long productId, Integer quantity, Double price) {
        this.id = id;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
}
