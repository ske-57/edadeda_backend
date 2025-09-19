package com.example.edadeda_backend.model.dto.user;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

public class UserCreateRequest {

    @Getter
    private String name;

    @JsonProperty(value = "is_seller")
    private Boolean isSeller = false;

    public UserCreateRequest() {
    }

    public UserCreateRequest(String name, Boolean isSeller) {
        this.name = name;
        this.isSeller = isSeller;
    }

    public Boolean getSeller() {
        return isSeller;
    }
}
