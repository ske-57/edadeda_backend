package com.example.edadeda_backend.controller;

import com.example.edadeda_backend.model.dto.cart.CartCreateRequest;
import com.example.edadeda_backend.model.dto.cart.CartResponse;
import com.example.edadeda_backend.model.dto.cartItem.CartItemCreateRequest;
import com.example.edadeda_backend.model.dto.cartItem.CartItemResponse;
import com.example.edadeda_backend.model.dto.item.ItemResponse;
import com.example.edadeda_backend.service.cart.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Cart")
@RequestMapping("/api/v1/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @Operation(summary = "Create new cart")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CartResponse createCart(@RequestBody CartCreateRequest req) {
        return cartService.createCart(req);
    }

    @Operation(summary = "Get items by cart id")
    @GetMapping("/{cart_id}/items")
    @ResponseStatus(HttpStatus.OK)
    public List<ItemResponse> getItemsByCartId(@PathVariable(name = "cart_id") Long cartId) {
        return cartService.getAllItemsByCartId(cartId);
    }

    @Operation(summary = "Create new cart item")
    @PostMapping("/{cart_id}/items")
    @ResponseStatus(HttpStatus.OK)
    public CartItemResponse createCartItem(@PathVariable(name = "cart_id") Long cartId, @RequestBody CartItemCreateRequest req) {
        return cartService.createCartItem(cartId, req);
    }

    @Operation(summary = "Get cart by user id")
    @GetMapping(value = "/{user_id}")
    @ResponseStatus(HttpStatus.OK)
    public CartResponse getCartByUserId(@PathVariable(name = "user_id") Long userId) {
        return cartService.getCartByUserId(userId);
    }

    @Operation(summary = "Delete cart by id")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCart(@PathVariable Long id){
        cartService.deleteCartById(id);
    }

}
