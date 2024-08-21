package com.example.orderservice.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Entity class representing an Order.
 * Maps to the "order" table in the database.
 */
@Data
@Entity
@Table(name = "\"order\"") // Escape the reserved word "order" for the table name
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier for the order

    @Column(name = "customer_id")
    private Long customerId; // ID of the customer who placed the order

    @Column(name = "product_id")
    private Long productId; // ID of the product being ordered

    private Integer quantity; // Quantity of the product ordered
    private Double totalPrice; // Total price of the order

    /**
     * Default constructor for the Order entity.
     */
    public Order() {
    }

    /**
     * Constructor for creating an Order with specified fields.
     *
     * @param id Unique identifier of the order.
     * @param customerId ID of the customer who placed the order.
     * @param productId ID of the product being ordered.
     * @param quantity Quantity of the product ordered.
     * @param totalPrice Total price of the order.
     */
    public Order(Long id, Long customerId, Long productId, Integer quantity, Double totalPrice) {
        this.id = id;
        this.customerId = customerId;
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }


}
