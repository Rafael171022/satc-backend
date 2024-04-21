package com.rafael.br.apibackend.Services;

import com.rafael.br.apibackend.Models.ProdutoModel;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class PorProdutoService {
    public Object listaProduto(String cod) {
            RestTemplate restTemplate = new RestTemplate();

            RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
            restTemplate = restTemplateBuilder.build();

            ProdutoModel newProduto = new ProdutoModel();
            newProduto.setCod_produto(cod);

            String uri = "http://localhost:9000/listarprodutos/"+cod;
            ProdutoModel prod = restTemplate.getForObject(uri,ProdutoModel.class);
            return prod;
        }

}

