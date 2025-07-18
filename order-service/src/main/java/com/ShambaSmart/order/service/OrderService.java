package com.ShambaSmart.order.service;

import com.ShambaSmart.order.dto.OrderDto;
import com.ShambaSmart.order.mapper.OrderMapper;
import com.ShambaSmart.order.model.Order;
import com.ShambaSmart.order.repository.OrderRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    // createOrder method to save an orderDto to the database.
    public Order createOrder(OrderDto orderDto) {

        if (orderRepository.existsById(orderDto.getId())) {
            throw new IllegalArgumentException("Order with ID " + orderDto.getId() + " already exists.");
        }
        // Convert orderDto to Order entity using the OrderMapper and save it to the database
        Order order = orderMapper.DtoToOrder(orderDto);
        return orderRepository.save(order);
    }

    //get orders from the database,convert them to DTOs, and return a paginated list
    public List<OrderDto> getAllOrders(int page, int size) {
        // Fetch paginated data from Database and convert to DTOs
        Pageable pageable = PageRequest.of(page, size);
        List<Order> orders = orderRepository.findAll(pageable).getContent();
        return orderMapper.OrderListToDto(orders);
    }

    // getOrderById method to fetch an order by its ID, convert it to DTO, and return it.
    public OrderDto getOrderById(Long id) {

        // Fetch by id convert to DTO
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order with ID " + id + " does not exist."));
        return orderMapper.OrderToDto(order);
    }

    // deleteOrder method to delete an order by its ID.
    public void deleteOrder(Long id) {

        // Check if the order exists before deleting
        if (!orderRepository.existsById(id)) {
            throw new IllegalArgumentException("Order with ID " + id + " does not exist.");
        }
        orderRepository.deleteById(id);
    }
}
