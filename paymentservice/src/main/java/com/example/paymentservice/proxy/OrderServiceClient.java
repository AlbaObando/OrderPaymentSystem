package com.example.paymentservice.proxy;

import com.example.paymentservice.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Feign client interface for communicating with the Order Service.
 * This client is used to interact with the Order Service to retrieve order information.
 */
@FeignClient(name = "orderservice", url = "http://localhost:8081/orders")
public interface OrderServiceClient {

    /**
     * Retrieves the order details by its ID.
     *
     * @param id the unique identifier of the order
     * @return the OrderDto containing details of the order
     */
    @GetMapping("/{id}")
    OrderDto getOrderById(@PathVariable("id") Long id);
}



