package com.example.edadeda_backend.model.dto.cart;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CartResponse {

    private Long id;

    @JsonProperty(value = "item_id")
    private Long itemId;

    private final Integer quantity = 1;

    @JsonProperty(value = "created_at")
    private LocalDateTime createdAt;

    public CartResponse() {
    }

    public CartResponse(Long id, Long itemId, LocalDateTime created_at) {
        this.id = id;
        this.itemId = itemId;
        this.createdAt = created_at;
    }
}
