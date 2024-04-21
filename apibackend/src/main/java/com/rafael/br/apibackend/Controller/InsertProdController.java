package com.rafael.br.apibackend.Controller;
import com.rafael.br.apibackend.Models.ProdutoModel;
import com.rafael.br.apibackend.Services.InsertProdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;


@RestController
public class InsertProdController {

    @Autowired
    private InsertProdService insertProdService;

    @PostMapping("/inserirProduto")
    public ResponseEntity<Object> inserirProduto(@RequestBody ProdutoModel produtoModel) throws Exception {
        try {
            ProdutoModel produtoInserido = (ProdutoModel) insertProdService.insertProdutos(
                    produtoModel.getCod_produto(),
                    produtoModel.getDesc_produto(),
                    produtoModel.getCod_ean13(),
                    produtoModel.getPreco(),
                    produtoModel.getDt_cad(),
                    produtoModel.getDt_alt()
            );


            return
                    ResponseEntity.status(HttpStatus.valueOf(201))
                    .contentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE))
                    .body("Produto inserido com sucesso!");

        } catch (HttpClientErrorException.BadRequest e) {
            return ResponseEntity.status(HttpStatus.valueOf(400))
                    .body("Erro: O item já foi inserido no banco de dados.");
        }
    }
}