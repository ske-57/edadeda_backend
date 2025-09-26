package com.example.edadeda_backend.model.dto.cartItem;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CartItemCreateRequest {

    @JsonProperty(value = "cart_id")
    private Long cartId;

    @JsonProperty(value = "item_id")
    private Long itemId;

    private Integer qty = 1;

    @JsonProperty(value = "total_price")
    private Long totalPrice;

    public CartItemCreateRequest() {
    }

    public CartItemCreateRequest(Long cartId, Long itemId,
                                 Integer qty, Long totalPrice) {
        this.cartId = cartId;
        this.itemId = itemId;
        this.qty = qty;
        this.totalPrice = totalPrice;
    }
}
