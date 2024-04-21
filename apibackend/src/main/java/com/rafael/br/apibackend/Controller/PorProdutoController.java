package com.rafael.br.apibackend.Controller;

import com.rafael.br.apibackend.Services.PorProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
public class PorProdutoController {

    @Autowired
    private PorProdutoService porProdutoService;

    @GetMapping("/listaporprodutos/{id}")
    public ResponseEntity<Object> porProduto(@PathVariable("id") String id) throws Exception {
        Object produto = porProdutoService.listaProduto(id);

        if (produto != "") {
            return ResponseEntity.status(HttpStatus.valueOf(200)).body(produto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
        }
    }
}


