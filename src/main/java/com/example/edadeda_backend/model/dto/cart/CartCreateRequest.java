package com.example.edadeda_backend.model.dto.cart;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CartCreateRequest {

    @JsonProperty(value = "user_id")
    private Long userId;

    public CartCreateRequest() {
    }

    public CartCreateRequest(Long userId) {
        this.userId = userId;
    }
}
