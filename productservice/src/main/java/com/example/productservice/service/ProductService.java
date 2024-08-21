package com.example.productservice.service;

import com.example.productservice.dto.ProductDto;
import com.example.productservice.proxy.ProductServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Service class for managing product operations.
 *
 * This class acts as a bridge between the controller layer and the external product API.
 * It handles the business logic related to product operations and communicates with the
 * external API using the ProductServiceProxy.
 */
@Service
public class ProductService {

    private final ProductServiceProxy productServiceProxy;

    /**
     * Constructor for injecting the ProductServiceProxy dependency.
     *
     * @param productServiceProxy The Feign client for communicating with the external product API.
     */
    @Autowired
    public ProductService(ProductServiceProxy productServiceProxy) {
        this.productServiceProxy = productServiceProxy;
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param productId The ID of the product to retrieve.
     * @return A ProductDto representing the details of the requested product.
     */
    public ProductDto getProduct(Long productId) {
        return productServiceProxy.getProduct(productId);
    }

    /**
     * Retrieves all products.
     *
     * @return A List of ProductDto representing all available products.
     */
    public List<ProductDto> getAllProducts() {
        // Convert array to list for easier handling
        return Arrays.asList(productServiceProxy.getAllProducts());
    }
}

