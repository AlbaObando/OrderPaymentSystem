package com.example.orderservice.controller;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.exception.ErrorResponse;
import com.example.orderservice.exception.OrderNotFoundException;
import com.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Handles the creation of a new order.
     *
     * @param orderDto Data Transfer Object for the order to be created.
     * @return ResponseEntity containing the created OrderDto and HTTP status code 201 (Created) if successful,
     *         or an ErrorResponse with HTTP status code 400 (Bad Request) if there is a runtime exception.
     */
    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderDto orderDto) {
        try {
            OrderDto createdOrder = orderService.createOrder(orderDto);
            return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Retrieves all orders.
     *
     * @return ResponseEntity containing a list of OrderDto and HTTP status code 200 (OK) if successful,
     *         or an ErrorResponse with HTTP status code 404 (Not Found) if no orders are found.
     */
    @GetMapping
    public ResponseEntity<?> getAllOrders() {
        try {
            List<OrderDto> orders = orderService.getAllOrders();
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (OrderNotFoundException e) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Retrieves a specific order by its ID.
     *
     * @param id The ID of the order to retrieve.
     * @return ResponseEntity containing the OrderDto and HTTP status code 200 (OK) if successful,
     *         or an ErrorResponse with HTTP status code 404 (Not Found) if the order is not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Long id) {
        try {
            OrderDto order = orderService.getOrderById(id);
            return new ResponseEntity<>(order, HttpStatus.OK);
        } catch (OrderNotFoundException e) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Updates an existing order by its ID.
     *
     * @param id The ID of the order to update.
     * @param orderDto Data Transfer Object with the updated order details.
     * @return ResponseEntity containing the updated OrderDto and HTTP status code 200 (OK) if successful,
     *         or an ErrorResponse with HTTP status code 404 (Not Found) if the order is not found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> updateOrder(@PathVariable Long id, @RequestBody OrderDto orderDto) {
        try {
            OrderDto updatedOrder = orderService.updateOrder(id, orderDto);
            return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
        } catch (OrderNotFoundException e) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Deletes an existing order by its ID.
     *
     * @param id The ID of the order to delete.
     * @return ResponseEntity with HTTP status code 204 (No Content) if successful,
     *         or an ErrorResponse with HTTP status code 404 (Not Found) if the order is not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        try {
            orderService.deleteOrder(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (OrderNotFoundException e) {
            ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }
}
