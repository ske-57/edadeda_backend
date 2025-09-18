package com.example.edadeda_backend.model.dto.user;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;

public class UserCreateRequest {

    private String name;

    @JsonProperty(value = "is_seller")
    private Boolean isSeller = false;

    public UserCreateRequest() {
    }

    public UserCreateRequest(String name, Boolean isSeller) {
        this.name = name;
        this.isSeller = isSeller;
    }

    public String getName() {
        return name;
    }

    public Boolean getSeller() {
        return isSeller;
    }
}
