package com.example.edadeda_backend.controller;

import com.example.edadeda_backend.model.dto.cartItem.CartItemCreateRequest;
import com.example.edadeda_backend.model.dto.cartItem.CartItemResponse;
import com.example.edadeda_backend.service.cartItem.CartItemServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Cart Item")
@RequestMapping(value = "api/v1/cartItems")
public class CartItemController {
    private final CartItemServiceImpl cartItemService;

    public CartItemController(CartItemServiceImpl cartItemService) {
        this.cartItemService = cartItemService;
    }

    @Operation(summary = "Get all cart items by cart id")
    @GetMapping(value = "/{cart_id}")
    @ResponseStatus(HttpStatus.OK)
    public List<CartItemResponse> getCartItems(@PathVariable(value = "cart_id") Long cartId) {
        return cartItemService.getAllByCartId(cartId);
    }

    @PostMapping()
    public CartItemResponse create(@RequestBody CartItemCreateRequest req) {
        return cartItemService.createCartItem(req);
    }
}
