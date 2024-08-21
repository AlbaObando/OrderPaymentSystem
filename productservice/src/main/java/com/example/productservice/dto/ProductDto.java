package com.example.productservice.dto;

import lombok.Data;

/**
 * Data Transfer Object (DTO) for transferring product data.
 *
 * This class is used to encapsulate the data of a product and transfer it between
 * the service layer and the controller layer. It serves as a plain container for
 * product-related information.
 */
@Data
public class ProductDto {

    /**
     * The unique identifier of the product.
     *
     * This field represents the primary key of the product in the database.
     */
    private Long id;

    /**
     * The title or name of the product.
     *
     * This field represents the name of the product as it will be displayed to users.
     */
    private String title;

    /**
     * A detailed description of the product.
     *
     * This field provides additional information about the product, including its features
     * and specifications.
     */
    private String description;

    /**
     * The price of the product.
     *
     * This field represents the cost of the product, which is used for display and calculations.
     */
    private Double price;

    /**
     * The category to which the product belongs.
     *
     * This field classifies the product into a specific category, aiding in organization and
     * search functionality.
     */
    private String category;

    /**
     * The URL or path of the product image.
     *
     * This field holds the link to the product's image, which is used for visual representation
     * in user interfaces.
     */
    private String image;
}

