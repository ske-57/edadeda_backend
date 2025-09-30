package com.example.edadeda_backend.model.dto.item;


import com.example.edadeda_backend.model.entity.EnumItemStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ItemUpdateRequest {

    private String title;

    private String description;

    private Long price;

    private String location;

    private String status = EnumItemStatus.AVAILABLE.toString();

    private String auto_report_link;

    public ItemUpdateRequest() {
    }

    public ItemUpdateRequest(String title, String description,
                             Long price, String location,
                             String status, String auto_report_link) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.location = location;
        this.status = status;
        this.auto_report_link = auto_report_link;
    }
}

