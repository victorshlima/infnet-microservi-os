package com.victation.AppLocacao.service;

import com.victation.AppLocacao.client.CatalogoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;

import java.util.Collection;
import java.util.List;

@Service
public class CatalogoService {


    @Autowired
    private CatalogoClient catalogoClient;


    public ResponseEntity<Collection<Object>> getCatalogo (){
    return  catalogoClient.carrosGet();
    }

}
