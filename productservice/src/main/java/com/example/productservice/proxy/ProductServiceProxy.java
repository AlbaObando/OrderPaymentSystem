package com.example.productservice.proxy;

import com.example.productservice.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Feign client interface for interacting with the external product API.
 *
 * This interface defines methods for communicating with an external API to retrieve
 * product information. Feign clients simplify the process of making HTTP requests
 * and handling responses.
 */
@FeignClient(name = "external-product-api", url = "https://fakestoreapi.com")
public interface ProductServiceProxy {

    /**
     * Retrieves a product by its ID from the external API.
     *
     * @param productId The ID of the product to retrieve.
     * @return A ProductDto representing the details of the requested product.
     */
    @GetMapping("/products/{productId}")
    ProductDto getProduct(@PathVariable("productId") Long productId);

    /**
     * Retrieves all products from the external API.
     *
     * @return An array of ProductDto representing all products available.
     *         Note: Ensure that the external API supports retrieving all products.
     */
    @GetMapping("/products")
    ProductDto[] getAllProducts();  // If the external API supports retrieving all products
}

