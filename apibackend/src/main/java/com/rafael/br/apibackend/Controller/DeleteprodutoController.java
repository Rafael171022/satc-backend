package com.rafael.br.apibackend.Controller;


import com.rafael.br.apibackend.Models.DeleteModel;
import com.rafael.br.apibackend.Models.ProdutoModel;
import com.rafael.br.apibackend.Services.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
public class DeleteprodutoController {

    @Autowired
    private DeleteService deleteService;
    @Autowired
    private ProdutoModel produtoModel;

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Object> deletarProdutos(@PathVariable("id") String id) throws Exception {
        boolean produtoDeletar = deleteService.deletarProd(id);

        if (produtoDeletar) {
            return ResponseEntity.status(HttpStatus.valueOf(200)).body("Produto "+id+" deletado com sucessoo");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Produto "+id+" não encontrado");
        }
    }


}
