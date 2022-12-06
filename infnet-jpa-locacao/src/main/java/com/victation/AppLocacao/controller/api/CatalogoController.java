package com.victation.AppLocacao.controller.api;


import com.victation.AppLocacao.model.domain.Carro;
import com.victation.AppLocacao.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("catalogo")
public class CatalogoController {


    @Autowired
    private  CarroService carroService;

    @GetMapping("/carros")
    public Collection<Carro> carrosGet(){
        return carroService.obterLista();
    }

}
