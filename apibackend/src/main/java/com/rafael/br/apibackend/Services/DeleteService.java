package com.rafael.br.apibackend.Services;

import com.rafael.br.apibackend.Models.DeleteModel;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DeleteService {
    public boolean deletarProd(String cod) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "http://localhost:9000/deleteproduto/"+cod;
        restTemplate.delete(uri);
        return true;

    }

}
