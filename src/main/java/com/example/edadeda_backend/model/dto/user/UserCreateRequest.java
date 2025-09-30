package com.example.edadeda_backend.model.dto.user;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class UserCreateRequest {

    private String name;

    @JsonProperty(value = "tg_id")
    private Long tgId;

    public UserCreateRequest() {
    }

    public UserCreateRequest(String name) {
        this.name = name;
    }

}
