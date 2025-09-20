package com.example.edadeda_backend.model.dto.cart;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CartCreateRequest {

//    private Long id;

    @JsonProperty(value = "user_id")
    private final Long userId;

    @JsonProperty(value = "item_id")
    private Long itemId;

//    private Integer quantity;

//    private final LocalDateTime createdAt = LocalDateTime.now();

//    public CartCreateResponse() {
//    }

    public CartCreateRequest(Long userId, Long itemId) {
        this.userId = userId;
        this.itemId = itemId;
    }
}
