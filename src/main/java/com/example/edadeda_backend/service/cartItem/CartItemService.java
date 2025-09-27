package com.example.edadeda_backend.service.cartItem;

import com.example.edadeda_backend.model.dto.cart.CartCreateRequest;
import com.example.edadeda_backend.model.dto.cart.CartResponse;
import com.example.edadeda_backend.model.dto.cartItem.CartItemCreateRequest;
import com.example.edadeda_backend.model.dto.cartItem.CartItemResponse;
import com.example.edadeda_backend.model.entity.CartItem;

import java.util.List;

public interface CartItemService {
    CartItemResponse createCartItem(CartItemCreateRequest req);
    List<CartItemResponse> getAllByCartId(Long cartId);
}
