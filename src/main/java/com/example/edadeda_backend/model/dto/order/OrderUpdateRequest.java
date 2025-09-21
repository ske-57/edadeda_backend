package com.example.edadeda_backend.model.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public class OrderUpdateRequest {

    @Getter
    @JsonProperty(value = "item_id")
    private Long itemId;

    @Getter
    private Long price;

    public OrderUpdateRequest() {
    }

    public OrderUpdateRequest(Long itemId, Long price) {
        this.itemId = itemId;
        this.price = price;
    }
}
