package com.example.edadeda_backend.controller;

import com.example.edadeda_backend.model.dto.cart.CartCreateRequest;
import com.example.edadeda_backend.model.dto.cart.CartResponse;
import com.example.edadeda_backend.model.dto.cart.CartUpdateRequest;
import com.example.edadeda_backend.service.cart.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping(value = "/{id}")
    public CartResponse getCart(@PathVariable Long id){
        return cartService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CartResponse createCart(@RequestBody CartCreateRequest req) {
        return cartService.createCart(req);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CartResponse updateCart(@PathVariable Long id, @RequestBody CartUpdateRequest req) {
        return cartService.updateCart(id, req);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCart(@PathVariable Long id){
        cartService.deleteCartById(id);
    }

}
