package com.example.edadeda_backend.service.cart;

import com.example.edadeda_backend.model.dto.cart.CartCreateRequest;
import com.example.edadeda_backend.model.dto.cart.CartResponse;
import com.example.edadeda_backend.model.dto.item.ItemResponse;

import java.util.List;

public interface CartService {
    CartResponse createCart(CartCreateRequest req);
//    CartResponse findById(Long id);
    List<CartResponse> getAllCarts();
    CartResponse getCartByUserId(Long userId);
//    CartResponse updateCart(Long id, CartUpdateRequest req);
    List<ItemResponse> getAllItemsByCartId(Long cartId);
    void deleteCartById(Long cartId);
}
