package com.example.edadeda_backend.model.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserUpdateRequest {

    private String name;

    @JsonProperty(value = "is_seller")
    private Boolean isSeller;

    public UserUpdateRequest() {
    }

    public UserUpdateRequest(String name, Boolean isSeller) {
        this.name = name;
        this.isSeller = isSeller;
    }

    public String getName() {
        return name;
    }

    public Boolean getIsSeller() {
        return isSeller;
    }
}
