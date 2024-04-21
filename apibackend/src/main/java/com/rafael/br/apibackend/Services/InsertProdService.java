package com.rafael.br.apibackend.Services;

import com.rafael.br.apibackend.Models.ProdutoInseridoModel;
import com.rafael.br.apibackend.Models.ProdutoModel;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InsertProdService {
    public Object insertProdutos(String cod, String desc, String ean13, Double preco, String dt_cad, String dt_alt) throws Exception {
        RestTemplate restTemplate = new RestTemplate();

        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();

        ProdutoModel novoProduto = new ProdutoModel();
        novoProduto.setCod_produto(cod);
        novoProduto.setDesc_produto(desc);
        novoProduto.setCod_ean13(ean13);
        novoProduto.setPreco(preco);
        novoProduto.setDt_cad(dt_cad);
        novoProduto.setDt_alt(dt_alt);

        ProdutoModel produtoInserido = restTemplate.postForObject("http://localhost:9000/inserirproduto/", novoProduto, ProdutoModel.class);
        return produtoInserido;
    }

}




