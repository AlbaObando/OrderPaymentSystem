package com.example.orderservice.dto;

import lombok.Data;

/**
 * Data Transfer Object (DTO) for representing product details.
 */
@Data
public class ProductDto {

    private Long id;           // Unique identifier for the product
    private String title;      // Title or name of the product
    private String description; // Description of the product
    private Double price;      // Price of the product
    private String category;   // Category to which the product belongs
    private String image;      // URL or path to the product image

    /**
     * Default constructor for ProductDto.
     * This constructor is provided by Lombok's @Data annotation but is also explicitly defined here.
     */
    public ProductDto() {
    }

    /**
     * Constructor for creating a ProductDto with specified fields.
     *
     * @param id Unique identifier of the product.
     * @param title Title or name of the product.
     * @param description Description of the product.
     * @param price Price of the product.
     * @param category Category to which the product belongs.
     * @param image URL or path to the product image.
     */
    public ProductDto(Long id, String title, String description, Double price, String category, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
        this.image = image;
    }
}
