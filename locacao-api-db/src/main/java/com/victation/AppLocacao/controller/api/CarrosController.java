package com.victation.AppLocacao.controller.api;


import com.victation.AppLocacao.model.domain.Carro;
import com.victation.AppLocacao.service.CarroService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("carros")
public class CarrosController {

    private static Logger logger = LoggerFactory.getLogger(CarrosController.class);

    @Autowired
    private  CarroService carroService;

    @GetMapping()
    public ResponseEntity<Collection<Carro>> carrosGet(){

        logger.info("Buscando  lista de carros");
        return ResponseEntity.ok(carroService.obterLista());
    }

}
