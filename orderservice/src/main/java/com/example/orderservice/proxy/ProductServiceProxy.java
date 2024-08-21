package com.example.orderservice.proxy;

import com.example.orderservice.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Feign client interface for interacting with the ProductService.
 */
@FeignClient(name = "productservice", url = "http://localhost:8084/products")
public interface ProductServiceProxy {

    /**
     * Retrieves a product by its ID from the ProductService.
     *
     * @param id The ID of the product to retrieve.
     * @return The {@link ProductDto} object representing the product.
     */
    @GetMapping("/{id}")
    ProductDto getProductById(@PathVariable("id") Long id);
}
