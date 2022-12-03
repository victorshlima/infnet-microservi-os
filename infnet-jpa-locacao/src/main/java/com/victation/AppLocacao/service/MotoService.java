package com.victation.AppLocacao.service;

import com.victation.AppLocacao.model.domain.Moto;
import com.victation.AppLocacao.model.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotoService  {

    @Autowired
    private MotoRepository motoRepository;

    public  void excluir(Integer id){
        motoRepository.deleteById(id);
    }

    public void incluir(Moto moto){
        motoRepository.save(moto);
    }

}
