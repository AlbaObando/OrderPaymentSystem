package com.example.orderservice.service;

import com.example.orderservice.dto.OrderDto;
import com.example.orderservice.dto.ProductDto;
import com.example.orderservice.entity.Order;
import com.example.orderservice.entity.OrderDetail;
import com.example.orderservice.exception.OrderNotFoundException;
import com.example.orderservice.exception.ProductNotFoundException;
import com.example.orderservice.repository.OrderDetailRepository;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.proxy.ProductServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service class for managing orders.
 * <p>
 * This class provides methods to handle CRUD operations for orders,
 * including creating, retrieving, updating, and deleting orders.
 * It also manages order details and interacts with the product service.
 * </p>
 */
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final ProductServiceProxy productServiceProxy;

    /**
     * Constructor for OrderService.
     *
     * @param orderRepository The repository for managing orders.
     * @param orderDetailRepository The repository for managing order details.
     * @param productServiceProxy Proxy for interacting with the product service.
     */
    @Autowired
    public OrderService(OrderRepository orderRepository,
                        OrderDetailRepository orderDetailRepository,
                        ProductServiceProxy productServiceProxy) {
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
        this.productServiceProxy = productServiceProxy;
    }

    /**
     * Retrieves all orders.
     *
     * @return A list of OrderDto objects representing all orders.
     * @throws OrderNotFoundException if no orders are found.
     */
    public List<OrderDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        if (orders.isEmpty()) {
            throw new OrderNotFoundException("No orders found.");
        }
        return orders.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    /**
     * Retrieves an order by its ID.
     *
     * @param id The ID of the order to retrieve.
     * @return An OrderDto object representing the order.
     * @throws OrderNotFoundException if the order with the specified ID is not found.
     */
    public OrderDto getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + id));
        return convertToDto(order);
    }

    /**
     * Creates a new order.
     *
     * @param orderDto The data transfer object containing order details.
     * @return The created OrderDto object.
     * @throws ProductNotFoundException if the product specified in the order is not found.
     */
    public OrderDto createOrder(OrderDto orderDto) {
        ProductDto product = getProductByIdOrThrow(orderDto.getProductId());

        double productPrice = product.getPrice();
        double totalPrice = calculateTotalPrice(productPrice, orderDto.getQuantity());

        Order order = new Order();
        order.setProductId(orderDto.getProductId());
        order.setCustomerId(orderDto.getCustomerId());
        order.setQuantity(orderDto.getQuantity());
        order.setTotalPrice(totalPrice);

        order = orderRepository.save(order);

        saveOrderDetail(order, productPrice);

        return convertToDto(order);
    }

    /**
     * Updates an existing order.
     *
     * @param id The ID of the order to update.
     * @param orderDto The data transfer object containing updated order details.
     * @return The updated OrderDto object.
     * @throws OrderNotFoundException if the order with the specified ID is not found.
     * @throws ProductNotFoundException if the product specified in the order is not found.
     */
    public OrderDto updateOrder(Long id, OrderDto orderDto) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found"));

        ProductDto product = getProductByIdOrThrow(orderDto.getProductId());

        double productPrice = product.getPrice();
        double totalPrice = calculateTotalPrice(productPrice, orderDto.getQuantity());

        order.setProductId(orderDto.getProductId());
        order.setCustomerId(orderDto.getCustomerId());
        order.setQuantity(orderDto.getQuantity());
        order.setTotalPrice(totalPrice);

        order = orderRepository.save(order);

        return convertToDto(order);
    }

    /**
     * Deletes an order by its ID.
     *
     * @param id The ID of the order to delete.
     * @throws OrderNotFoundException if the order with the specified ID is not found.
     */
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order not found"));
        orderRepository.delete(order);
    }

    /**
     * Saves the details of an order.
     *
     * @param order The order entity whose details are to be saved.
     * @param productPrice The price of the product in the order.
     */
    private void saveOrderDetail(Order order, double productPrice) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(order.getId());
        orderDetail.setProductId(order.getProductId());
        orderDetail.setQuantity(order.getQuantity());
        orderDetail.setPrice(productPrice);

        orderDetailRepository.save(orderDetail);
    }

    /**
     * Converts an Order entity to an OrderDto.
     *
     * @param order The Order entity to convert.
     * @return An OrderDto object representing the order.
     */
    private OrderDto convertToDto(Order order) {
        ProductDto product = productServiceProxy.getProductById(order.getProductId());
        double productPrice = (product != null) ? product.getPrice() : 0.0;
        return new OrderDto(
                order.getCustomerId(),
                order.getId(),
                order.getProductId(),
                order.getQuantity(),
                productPrice,
                order.getTotalPrice()
        );
    }

    /**
     * Retrieves a product by its ID or throws an exception if not found.
     *
     * @param productId The ID of the product to retrieve.
     * @return The ProductDto object representing the product.
     * @throws ProductNotFoundException if the product with the specified ID is not found.
     */
    private ProductDto getProductByIdOrThrow(Long productId) {
        return Optional.ofNullable(productServiceProxy.getProductById(productId))
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    /**
     * Calculates the total price of an order.
     *
     * @param productPrice The price of the product.
     * @param quantity The quantity of the product.
     * @return The total price.
     */
    private double calculateTotalPrice(double productPrice, int quantity) {
        return productPrice * quantity;
    }
}
