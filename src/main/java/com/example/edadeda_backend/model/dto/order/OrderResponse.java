package com.example.edadeda_backend.model.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class OrderResponse {

    private Long id;

    @JsonProperty(value = "item_id")
    private Long itemId;

    @JsonProperty(value = "buyer_id")
    private Long buyerId;

    private Long price;

    public OrderResponse() {
    }

    public OrderResponse(long id, long itemId, long buyerId, long price) {
        this.id = id;
        this.itemId = itemId;
        this.buyerId = buyerId;
        this.price = price;
    }
}
