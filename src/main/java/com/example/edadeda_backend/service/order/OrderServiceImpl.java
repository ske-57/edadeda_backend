package com.example.edadeda_backend.service.order;

import com.example.edadeda_backend.exception.NotFoundException;
import com.example.edadeda_backend.model.dto.order.OrderCreateRequest;
import com.example.edadeda_backend.model.dto.order.OrderResponse;
import com.example.edadeda_backend.model.entity.Item;
import com.example.edadeda_backend.model.entity.Order;
import com.example.edadeda_backend.model.entity.User;
import com.example.edadeda_backend.repository.ItemRepository;
import com.example.edadeda_backend.repository.OrderRepository;
import com.example.edadeda_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
    }

    private OrderResponse toResponse(Order o) {
        return new OrderResponse(o.getId(), o.getItem().getId(),
                o.getUser().getId(), o.getPrice());
    }

    @Override
    public OrderResponse createOrder(OrderCreateRequest req) {
        User user = userRepository.findById(req.getUserId())
                .orElseThrow(() -> new NotFoundException("User for order not found"));

        Item item = itemRepository.findById(req.getItemId())
                .orElseThrow(() -> new NotFoundException("Item for order not found"));

        Order orderToCreate = new Order();
        orderToCreate.setItem(item);
        orderToCreate.setUser(user);
        orderToCreate.setPrice(req.getPrice());
        return toResponse(orderRepository.save(orderToCreate));
    }

    @Override
    public OrderResponse findById(Long id) {
        return toResponse(orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Order not found")));
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public List<OrderResponse> getOrdersByUserId(Long userId) {
        return orderRepository.getOrdersByUserId(userId)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        if (!orderRepository.existsById(id)) throw new NotFoundException("You try to delete not existed order");
        orderRepository.deleteById(id);
    }
}
