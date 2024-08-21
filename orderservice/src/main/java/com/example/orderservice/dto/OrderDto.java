package com.example.orderservice.dto;

import lombok.Data;

@Data
public class OrderDto {

    private Long customerId;  // Customer ID associated with the order
    private Long id;          // Unique identifier for the order
    private Long productId;   // ID of the product in the order
    private int quantity;     // Quantity of the product ordered
    private double productPrice; // Price of a single unit of the product
    private double totalPrice;   // Total price for the order (quantity * productPrice)

    /**
     * Constructor for creating an OrderDto with specified fields.
     *
     * @param customerId ID of the customer who placed the order.
     * @param id Unique identifier of the order.
     * @param productId ID of the product being ordered.
     * @param quantity Number of units of the product ordered.
     * @param productPrice Price of one unit of the product.
     * @param totalPrice Total cost of the order.
     */
    public OrderDto(Long customerId, Long id, Long productId, int quantity, double productPrice, double totalPrice) {
        this.customerId = customerId;
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.productPrice = productPrice;
        this.totalPrice = totalPrice;
    }
}
