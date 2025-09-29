package com.example.edadeda_backend.repository;

import com.example.edadeda_backend.model.dto.order.OrderResponse;
import com.example.edadeda_backend.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> getOrdersByUserId(Long userId);
}
