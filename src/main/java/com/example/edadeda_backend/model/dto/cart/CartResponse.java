package com.example.edadeda_backend.model.dto.cart;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CartResponse {

    private Long id;

    @JsonProperty(value = "user_id")
    private final Long userId;

    @JsonProperty(value = "item_id")
    private Long itemId;

    private final Integer quantity = 1;

    private final LocalDateTime created_at;

//    public CartResponse() {
//    }

    public CartResponse(Long id, Long userId, Long itemId, LocalDateTime created_at) {
        this.id = id;
        this.userId = userId;
        this.itemId = itemId;
        this.created_at = created_at;
    }
}
