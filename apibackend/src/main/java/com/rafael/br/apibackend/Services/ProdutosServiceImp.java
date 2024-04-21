package com.rafael.br.apibackend.Services;


import com.rafael.br.apibackend.Models.ProdutoModel;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProdutosServiceImp {
    public Object buscarProdutos() {
        RestTemplate restTemplate = new RestTemplate();

        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();

        restTemplate = restTemplateBuilder.build();

        ProdutoModel produtos[] = restTemplate.getForObject ("http://localhost:9000/listartodos",ProdutoModel[].class);
        return produtos;
    }
}


