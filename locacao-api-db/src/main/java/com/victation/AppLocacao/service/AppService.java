package com.victation.AppLocacao.service;

import com.victation.AppLocacao.model.domain.app.Projeto;
import com.victation.AppLocacao.model.test.AppImpressao;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    private Projeto projeto;
    public void incluir(Projeto projeto){
        this.projeto = projeto;
   };

    public Projeto obterProjeto(){
        return this.projeto;
    }

}
