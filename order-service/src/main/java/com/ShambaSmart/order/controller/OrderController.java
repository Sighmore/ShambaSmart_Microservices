package com.ShambaSmart.order.controller;

import com.ShambaSmart.order.dto.OrderDto;
import com.ShambaSmart.order.model.Order;
import com.ShambaSmart.order.service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "Order Management", description = "APIs for managing orders")
public class OrderController {

    private final OrderService orderService;

    // Create a new orderDto
    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody OrderDto orderDto) {
        log.info("Placing new orderDto: {}", orderDto);
        return ResponseEntity.ok(orderService.createOrder(orderDto));
    }

    // Get all orders with pagination
    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        log.info("Fetching all orders - page: {}, size: {}", page, size);
        return ResponseEntity.ok(orderService.getAllOrders(page, size));
    }

    // Get an order by ID
    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long id) {
        log.info("Fetching order with ID: {}", id);
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    // Delete an order
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        log.info("Deleting order with ID: {}", id);
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}

