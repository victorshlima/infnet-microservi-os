package com.victation.AppLocacao.service;

import com.victation.AppLocacao.model.domain.Locacao;
import com.victation.AppLocacao.model.domain.Usuario;
import com.victation.AppLocacao.model.repository.LocacaoRepository;
import com.victation.AppLocacao.model.test.AppImpressao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class LocacaoService {


    @Autowired
    private LocacaoRepository locacaoRepository;

    public Collection<Locacao> obterLista(){
        return (Collection<Locacao>) locacaoRepository.findAll();
    }

    public Collection<Locacao> obterLista(Usuario usuer){
        return (Collection<Locacao>) locacaoRepository.findAll(usuer.getId());
    }

    public  void excluir(Integer id){
        locacaoRepository.deleteById(id);
    }

    public void incluir(Locacao locacao){
        locacaoRepository.save(locacao);

    }

}
