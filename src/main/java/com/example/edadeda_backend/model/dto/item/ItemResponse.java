package com.example.edadeda_backend.model.dto.item;

import com.example.edadeda_backend.model.entity.EnumItemStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ItemResponse {

    private Long id;

    private String title;

    private String description;

    private Long price;

    private String location;

    private EnumItemStatus status = EnumItemStatus.AVAILABLE;

    private String auto_report_link;

    @JsonProperty(value = "seller_id")
    private Long sellerId;


    public ItemResponse() {}

    public ItemResponse(Long id, String title, String description,
                        Long price, String location,
                        EnumItemStatus status, String auto_report_link,
                        Long sellerId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.location = location;
        this.status = status;
        this.auto_report_link = auto_report_link;
        this.sellerId = sellerId;
    }

}
