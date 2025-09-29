package com.example.edadeda_backend.controller;

import com.example.edadeda_backend.model.dto.order.OrderCreateRequest;
import com.example.edadeda_backend.model.dto.order.OrderResponse;
import com.example.edadeda_backend.service.order.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Order")
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Operation(summary = "Get orders list")
    @GetMapping
    public List<OrderResponse> getOrders() {
        return orderService.getAllOrders();
    }

    @Operation(summary = "Get orders list by user id")
    @GetMapping("/{user_id}")
    public List<OrderResponse> getOrder(@PathVariable(value = "user_id") Long userId) {
        return orderService.getOrdersByUserId(userId);
    }

    @Operation(summary = "Create new order")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse createOrder(@RequestBody OrderCreateRequest req) {
        return orderService.createOrder(req);
    }

    @Operation(summary = "Delete order by id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteById(id);
    }
}
