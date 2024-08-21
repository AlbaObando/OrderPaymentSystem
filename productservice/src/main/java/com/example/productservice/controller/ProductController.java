package com.example.productservice.controller;

import com.example.productservice.dto.ProductDto;
import com.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for handling HTTP requests related to products.
 *
 * This class is responsible for managing the CRUD operations related to products.
 * Currently, it only supports read operations: retrieving a single product and retrieving all products.
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    // Dependency injection of the ProductService via constructor
    private final ProductService productService;

    /**
     * Constructor for injecting ProductService dependency.
     *
     * @param productService The service layer component responsible for business logic.
     */
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Endpoint to retrieve a product by its ID.
     *
     * @param productId The ID of the product to retrieve.
     * @return ResponseEntity containing the product details or a 404 Not Found status if the product does not exist.
     */
    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long productId) {
        ProductDto product = productService.getProduct(productId);
        return ResponseEntity.ok(product);
    }

    /**
     * Endpoint to retrieve all products.
     *
     * @return ResponseEntity containing a list of all products.
     */
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }
}
