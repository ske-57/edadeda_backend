package com.example.edadeda_backend.model.dto.cartItem;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemResponse {

    private Long id;

    @JsonProperty(value = "cart_id")
    private Long cartId;

    @JsonProperty(value = "item_id")
    private Long itemId;

    private Integer qty;

    @JsonProperty(value = "total_price")
    private Long totalPrice;

    public CartItemResponse() {
    }

    public CartItemResponse(Long id, Long cartId,
                            Long itemId, Integer qty,
                            Long totalPrice) {
        this.id = id;
        this.cartId = cartId;
        this.itemId = itemId;
        this.qty = qty;
        this.totalPrice = totalPrice;
    }
}
