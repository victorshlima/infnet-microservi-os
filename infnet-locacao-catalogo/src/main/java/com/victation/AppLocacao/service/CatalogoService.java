package com.victation.AppLocacao.service;

import com.victation.AppLocacao.client.CatalogoClient;
import com.victation.AppLocacao.controller.LocacaoController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Collection;


@Service
public class CatalogoService {


    private static Logger logger = LoggerFactory.getLogger(CatalogoService.class);

    @Autowired
    private CatalogoClient catalogoClient;

    public ResponseEntity<Collection<Object>> getCatalogo (){
        logger.info("chamando API para retornar os dados do carro");
    return  catalogoClient.carrosGet();
    }

}
