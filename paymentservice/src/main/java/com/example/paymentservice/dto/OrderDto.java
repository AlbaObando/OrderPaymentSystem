package com.example.paymentservice.dto;

import lombok.Data;

/**
 * Data Transfer Object (DTO) for transferring order information.
 * This DTO is used to encapsulate order data and transfer it between different layers or services.
 */
@Data
public class OrderDto {

    private Long customerId;
    private Long id;
    private Long productId;
    private int quantity;
    private double productPrice;
    private double totalPrice;

    /**
     * Default constructor.
     * This no-argument constructor is required for frameworks and libraries
     * that require a default constructor for object creation.
     */
    public OrderDto() {}

    /**
     * Parameterized constructor.
     * Initializes a new instance of OrderDto with specified values for all fields.
     *
     * @param customerId the ID of the customer who placed the order
     * @param id the unique identifier of the order
     * @param productId the ID of the product ordered
     * @param quantity the quantity of the product ordered
     * @param productPrice the price of a single product
     * @param totalPrice the total price of the order
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

