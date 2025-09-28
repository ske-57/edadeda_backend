package com.example.edadeda_backend.model.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class UserResponse {

    private Long id;

    @JsonProperty(value = "tg_id")
    private Long tgId;

    private String name;

    @JsonProperty(value = "is_seller")
    private Boolean isSeller;

    public UserResponse() {
    }

    public UserResponse(Long id, Long tgId, String name, Boolean isSeller) {
        this.id = id;
        this.tgId = tgId;
        this.name = name;
        this.isSeller = isSeller;
    }

}
