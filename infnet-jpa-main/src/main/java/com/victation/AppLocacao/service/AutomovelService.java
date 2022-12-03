package com.victation.AppLocacao.service;

import com.victation.AppLocacao.model.domain.Automovel;
import com.victation.AppLocacao.model.domain.Usuario;
import com.victation.AppLocacao.model.repository.AutomovelRepository;
import com.victation.AppLocacao.model.test.AppImpressao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutomovelService {

    @Autowired
    private AutomovelRepository automovelRepository;

    public List<Automovel> obterLista(){
        return (List<Automovel>) automovelRepository.findAll();
    }
    public List<Automovel> obterLista(Usuario user){
        return (List<Automovel>) automovelRepository.findAll(user.getId());
    }

    public  void excluir(Integer id){
        automovelRepository.deleteById(id);
    }

    public void incluir(Automovel automovel, Usuario user){
        automovel.setUsuario(user);
        automovelRepository.save(automovel);
 }

}
