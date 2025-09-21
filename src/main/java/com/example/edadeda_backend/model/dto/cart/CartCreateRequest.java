package com.example.edadeda_backend.model.dto.cart;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CartCreateRequest {

    @JsonProperty(value = "user_id")
    private Long userId;

    @JsonProperty(value = "item_id")
    private Long itemId;

    public CartCreateRequest() {
    }

    public CartCreateRequest(Long userId, Long itemId) {
        this.userId = userId;
        this.itemId = itemId;
    }
}
