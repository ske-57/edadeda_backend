package com.example.edadeda_backend.model.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public class OrderCreateRequest {

    @Getter
    @JsonProperty(value = "item_id")
    private Long itemId;

    @Getter
    @JsonProperty(value = "user_id")
    private Long userId;

    @Getter
    private Long price;

    public OrderCreateRequest() {
    }

    public OrderCreateRequest(Long itemId, Long userId, Long price) {
        this.itemId = itemId;
        this.userId = userId;
        this.price = price;
    }
}