package com.rafael.br.apibackend.Controller;
import com.rafael.br.apibackend.Services.ProdutosServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutosController  {

    @Autowired
    private ProdutosServiceImp produtosServiceImp;

    @GetMapping("/listatodos")
    public ResponseEntity<Object> verResponse() {
        return  ResponseEntity.status(200)
                .contentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE))
                .body(produtosServiceImp.buscarProdutos());

    }
}