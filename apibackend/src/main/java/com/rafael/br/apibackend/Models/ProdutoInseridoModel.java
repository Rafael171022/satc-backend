package com.rafael.br.apibackend.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ProdutoInseridoModel {
    @JsonProperty("message")
    private String message;
    @JsonProperty("cod_produto")
    private String cod_produto;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCod_produto() {
        return cod_produto;
    }

    public void setCod_produto(String cod_produto) {
        this.cod_produto = cod_produto;
    }

    public static ProdutoInseridoModel fromJson(String json) throws IOException {
        return ProdutoInseridoModel.fromJson(json);
    }

}
