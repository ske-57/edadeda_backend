package com.example.edadeda_backend.model.dto;

import jakarta.validation.constraints.NotNull;

public class InitDataRequest {

    @NotNull
    private String initData;

    public InitDataRequest() {
    }


    public InitDataRequest(String initData) {
        this.initData = initData;
    }

    public String getInitData() {
        return initData;
    }

    public void setInitData(String initData) {
        this.initData = initData;
    }
}
