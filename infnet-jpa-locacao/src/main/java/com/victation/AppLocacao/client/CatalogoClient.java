package com.victation.AppLocacao.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("catalogo")
public interface CatalogoClient {

    @GetMapping("carros")
    ResponseEntity<List<Object>> carrosGet();


}
