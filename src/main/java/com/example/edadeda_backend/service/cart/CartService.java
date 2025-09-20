package com.example.edadeda_backend.service.cart;

import com.example.edadeda_backend.model.dto.cart.CartCreateRequest;
import com.example.edadeda_backend.model.dto.cart.CartResponse;
import com.example.edadeda_backend.model.dto.cart.CartUpdateRequest;

import java.util.List;

public interface CartService {
    CartResponse createCart(CartCreateRequest req);
    CartResponse findById(Long id);
    List<CartResponse> getAllCarts();
    CartResponse updateCart(Long id, CartUpdateRequest req);
    void deleteCartById(Long cartId);
}
