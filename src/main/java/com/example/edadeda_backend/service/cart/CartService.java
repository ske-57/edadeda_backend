package com.example.edadeda_backend.service.cart;

import com.example.edadeda_backend.model.dto.cart.CartCreateRequest;
import com.example.edadeda_backend.model.dto.cart.CartResponse;
import com.example.edadeda_backend.model.dto.cartItem.CartItemCreateRequest;
import com.example.edadeda_backend.model.dto.cartItem.CartItemResponse;
import com.example.edadeda_backend.model.dto.item.ItemResponse;

import java.util.List;

public interface CartService {
    CartResponse createCart(CartCreateRequest req);
    List<CartResponse> getAllCarts();
    CartResponse getCartByUserId(Long userId);
    List<ItemResponse> getAllItemsByCartId(Long cartId);
    CartItemResponse createCartItem(Long CartId, CartItemCreateRequest req);
    void deleteCartById(Long cartId);
}
