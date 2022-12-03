package com.victation.AppLocacao.service;

import com.victation.AppLocacao.model.domain.Caminhao;
import com.victation.AppLocacao.model.domain.Usuario;
import com.victation.AppLocacao.model.repository.CaminhaoRepository;
import com.victation.AppLocacao.model.test.AppImpressao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.Collection;

@Service
public class CaminhaoService {

    @Autowired
    public CaminhaoRepository caminhaoRepository;

    public Collection<Caminhao> obterLista(){
        return (Collection<Caminhao>) caminhaoRepository.findAll();
    }
    public Collection<Caminhao> obterLista(Usuario user){
        return (Collection<Caminhao>) caminhaoRepository.findAll(user.getId());
    }

    public  void excluir(Integer id){
        caminhaoRepository.deleteById(id);
    }

    public void incluir(Caminhao caminhao, @SessionAttribute("user") Usuario user){
        caminhao.setUsuario(user);
        caminhaoRepository.save(caminhao);
 }

}
