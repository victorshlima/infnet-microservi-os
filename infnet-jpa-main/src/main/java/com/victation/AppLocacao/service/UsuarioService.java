package com.victation.AppLocacao.service;


import com.victation.AppLocacao.model.domain.Usuario;
import com.victation.AppLocacao.model.repository.UsuarioRepository;
import com.victation.AppLocacao.model.test.AppImpressao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario validar(String email, String senha){

    //TODO criar a busca por email para retorno o ID
    Optional<Usuario> usuario = usuarioRepository.findByEmail(email);


        if (usuario != null && usuario.get() !=null && usuario.get().getSenha().equals(senha)){
            return usuario.get();
        }
        return null;
    }

    public  Collection<Usuario> obterLista(){
        return (Collection<Usuario>) usuarioRepository.findAll();
    }

    public  void excluir(Integer id){
        usuarioRepository.deleteById(id);
    }

    public void incluir(Usuario usuario){
        usuarioRepository.save(usuario);
  }


}
