package com.rafael.br.apibackend.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.IOException;

public class DeleteModel {
    @JsonProperty("message")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static DeleteModel fromJson(String json) throws IOException {
        return DeleteModel.fromJson(json);
    }
}
