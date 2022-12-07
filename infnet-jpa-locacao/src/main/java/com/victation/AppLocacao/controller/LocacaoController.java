package com.victation.AppLocacao.controller;

import com.victation.AppLocacao.client.CatalogoClient;
import com.victation.AppLocacao.service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("catalogo")
@EnableFeignClients
public class LocacaoController {

    @Autowired
    private CatalogoService catalogoService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${carros.endpoint.url}")
    private String carrosApiUrl;

    @GetMapping("/produtos")
    public ResponseEntity<Collection<Object>> carrosGet(){

        return   catalogoService.getCatalogo();
    }

    @GetMapping("/v2/produtos")
    public ResponseEntity<Object> carrosGet2(){
        var carroDTO = restTemplate.getForObject(carrosApiUrl, Object.class);
        return   ResponseEntity.ok(carroDTO);
    }

}
