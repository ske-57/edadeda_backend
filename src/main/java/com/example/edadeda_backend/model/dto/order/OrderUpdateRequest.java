package com.example.edadeda_backend.model.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public class OrderUpdateRequest {

    @Getter
    @JsonProperty(value = "item_id")
    private Long itemId;

    @Getter
    @JsonProperty(value = "buyer_id")
    private Long buyerId;

    @Getter
    private Long price;

    public OrderUpdateRequest() {
    }

    public OrderUpdateRequest(Long itemId, Long buyerId, Long price) {
        this.itemId = itemId;
        this.buyerId = buyerId;
        this.price = price;
    }
}
