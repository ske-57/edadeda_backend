package com.example.edadeda_backend.service.order;

import com.example.edadeda_backend.model.dto.order.OrderCreateRequest;
import com.example.edadeda_backend.model.dto.order.OrderResponse;

import java.util.List;

public interface OrderService {
    OrderResponse createOrder(OrderCreateRequest req);
    OrderResponse findById(Long id);
    List<OrderResponse> getAllOrders();
    List<OrderResponse> getOrdersByUserId(Long userId);
    void deleteById(Long id);
}
