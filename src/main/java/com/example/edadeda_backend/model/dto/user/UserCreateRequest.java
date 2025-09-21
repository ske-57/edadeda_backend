package com.example.edadeda_backend.model.dto.user;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.Getter;

@Getter
public class UserCreateRequest {

    private String name;

    public UserCreateRequest() {
    }

    public UserCreateRequest(String name) {
        this.name = name;
    }

}
