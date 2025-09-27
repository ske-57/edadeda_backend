package com.example.edadeda_backend.service.cart;

import com.example.edadeda_backend.model.dto.cart.CartCreateRequest;
import com.example.edadeda_backend.model.dto.cart.CartResponse;
import com.example.edadeda_backend.model.dto.item.ItemResponse;

import java.util.List;

public interface CartService {
    CartResponse createCart(CartCreateRequest req);
    List<CartResponse> getAllCarts();
    CartResponse getCartByUserId(Long userId);
    List<ItemResponse> getAllItemsByCartId(Long cartId);
    void deleteCartById(Long cartId);
}
