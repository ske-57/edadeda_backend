package com.example.edadeda_backend.model.dto.item;

import com.example.edadeda_backend.model.entity.EnumItemStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ItemCreateRequest {

    private String title;

    private String description;

    private Long price;

    private String location;

    private String auto_report_link;

    @JsonProperty(value = "seller_id")
    private Long sellerId;

    public ItemCreateRequest() {
    }

    public ItemCreateRequest(String title, String description,
                             Long price, String location,
                             String auto_report_link, Long sellerId) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.location = location;
        this.auto_report_link = auto_report_link;
        this.sellerId = sellerId;
    }
}
