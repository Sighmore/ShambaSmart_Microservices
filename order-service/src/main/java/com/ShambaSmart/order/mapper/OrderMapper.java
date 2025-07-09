package com.ShambaSmart.order.mapper;

import com.ShambaSmart.order.dto.OrderDto;
import com.ShambaSmart.order.dto.OrderItemDto;
import com.ShambaSmart.order.model.Order;
import com.ShambaSmart.order.model.OrderItem;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    //order to DTO conversion
    public OrderDto OrderToDto(Order order) {
        if (order == null) {
            return null;
        }
        OrderDto OrderDTO = new OrderDto();
        OrderDTO.setId(order.getId());
        OrderDTO.setFarmerId(order.getFarmerId());
        OrderDTO.setOrderDate(order.getOrderDate());
        OrderDTO.setTotalAmount(order.getTotalAmount());
        OrderDTO.setStatus(order.getStatus());
        // TODO: Implement OrderItem to DTO mapping here
        // Map OrderItem to OrderItemDto
        OrderDTO.setItems(order.getItems() == null ? null :
                order.getItems().stream()
                        .map(item -> {
                            // Assuming you have a method to map OrderItem to OrderItemDto
                            // Replace with actual mapping logic or method call
                            OrderItemDto itemDto = new OrderItemDto();
                            itemDto.setProductName(item.getProductName());
                            itemDto.setProductCode(item.getProductCode());
                            itemDto.setQuantity(item.getQuantity());
                            itemDto.setPricePerUnit(item.getPricePerUnit());
                            return itemDto;
                        })
                        .collect(Collectors.toList())
        );
        return OrderDTO;
    }

    // DTO to order conversion
    public Order DtoToOrder(OrderDto OrderDTO) {
        if (OrderDTO == null) {
            return null;
        }
        Order order = new Order();
        order.setId(OrderDTO.getId());
        order.setFarmerId(OrderDTO.getFarmerId());
        order.setOrderDate(OrderDTO.getOrderDate());
        order.setTotalAmount(OrderDTO.getTotalAmount());
        order.setStatus(OrderDTO.getStatus());
        // TODO: Implement OrderItemDto to Order mapping here
        // Map OrderItemDTO to OrderItem
        order.setItems(OrderDTO.getItems() == null ? null :
                OrderDTO.getItems().stream()
                        .map(itemDto -> {
                            // Assuming you have a method to map OrderItemDto to OrderItem
                            // Replace with actual mapping logic or method call
                            OrderItem item = new OrderItem();
                            item.setProductName(itemDto.getProductName());
                            item.setProductCode(itemDto.getProductCode());
                            item.setQuantity(itemDto.getQuantity());
                            item.setPricePerUnit(itemDto.getPricePerUnit());
                            return item;
                        })
                        .collect(Collectors.toList())
        );

        return order;

    }

    //convert List<Order> to List<OrderDto>
    public List<OrderDto> OrderListToDto(List<Order> orders) {
        if (orders == null || orders.isEmpty()) {
            return List.of();
        }
        return orders.stream()
                .map(this::OrderToDto)
                .collect(Collectors.toList());
    }
}
