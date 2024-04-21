package com.rafael.br.apibackend.Models;

import org.springframework.stereotype.Service;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

@Service
public class ProdutoModel {
    @JsonProperty("cod_produto")
    private String cod_produto;
    @JsonProperty("desc_produto")
    private String desc_produto;
    @JsonProperty("cod_ean13")
    private String cod_ean13;
    @JsonProperty("preco")
    private double preco;
    @JsonProperty("dt_cad")
    private String dt_cad;
    @JsonProperty("dt_alt")
    private String dt_alt;

    public String getCod_produto() {
        return cod_produto;
    }

    public void setCod_produto(String cod_produto) {
        this.cod_produto = cod_produto;
    }

    public String getDesc_produto() {
        return desc_produto;
    }

    public void setDesc_produto(String desc_produto) {
        this.desc_produto = desc_produto;
    }

    public String getCod_ean13() {
        return cod_ean13;
    }

    public void setCod_ean13(String cod_ean13) {
        this.cod_ean13 = cod_ean13;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDt_cad() {
        return dt_cad;
    }

    public void setDt_cad(String dt_cad) {
        this.dt_cad = dt_cad;
    }

    public String getDt_alt() {
        return dt_alt;
    }

    public void setDt_alt(String dt_alt) {
        this.dt_alt = dt_alt;
    }

    // Método para serializar um objeto ProdutoModel para JSON
    public String toJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(this);
    }

    // Método para desserializar um JSON para um objeto ProdutoModel
    public static ProdutoModel fromJson(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, ProdutoModel.class);
    }

    // Método para desserializar um JSON array para uma lista de objetos ProdutoModel
    public static List<ProdutoModel> fromJsonArray(String jsonArray) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonArray, objectMapper.getTypeFactory().constructCollectionType(List.class, ProdutoModel.class));
    }
}




