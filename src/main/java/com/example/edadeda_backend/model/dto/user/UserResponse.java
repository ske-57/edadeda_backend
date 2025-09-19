package com.example.edadeda_backend.model.dto.user;

import lombok.Getter;

@Getter
public class UserResponse {

    private Long id;

    private String name;

    private Boolean isSeller;

    public UserResponse() {
    }

    public UserResponse(Long id, String name, Boolean isSeller) {
        this.id = id;
        this.name = name;
        this.isSeller = isSeller;
    }

}
