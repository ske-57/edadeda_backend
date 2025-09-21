package com.example.edadeda_backend.model.dto.cart;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CartUpdateRequest {

    @JsonProperty(value = "item_id")
    private Long itemId;

    public CartUpdateRequest() {
    }

    public CartUpdateRequest(Long itemId) {
        this.itemId = itemId;
    }
}
