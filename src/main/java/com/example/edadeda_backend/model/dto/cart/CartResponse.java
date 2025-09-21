package com.example.edadeda_backend.model.dto.cart;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CartResponse {

    private Long id;

    @JsonProperty(value = "item_id")
    private Long itemId;

    @JsonProperty(value = "user_id")
    private Long userId;

    public CartResponse() {
    }

    public CartResponse(Long id, Long itemId, Long userId) {
        this.id = id;
        this.itemId = itemId;
        this.userId = userId;
    }
}
