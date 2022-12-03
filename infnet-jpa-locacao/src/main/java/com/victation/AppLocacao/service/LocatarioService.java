package com.victation.AppLocacao.service;

import com.victation.AppLocacao.model.domain.Locatario;
import com.victation.AppLocacao.model.domain.Usuario;
import com.victation.AppLocacao.model.repository.LocatarioRepository;
import com.victation.AppLocacao.model.test.AppImpressao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class LocatarioService {

    @Autowired
    private LocatarioRepository locatarioRepository;

    public Collection<Locatario> obterLista(){
        return (Collection<Locatario>) locatarioRepository.findAll();
    }

    public Collection<Locatario> obterLista(Usuario usuario){
        return  locatarioRepository.obterLista(usuario.getId());
    }

    public  void excluir(Integer id){
        locatarioRepository.deleteById(id);
    }

    public void incluir(Locatario locatario){
        locatarioRepository.save(locatario);
  }

}
