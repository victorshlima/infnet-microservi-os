package com.victation.AppLocacao.service;

import com.victation.AppLocacao.controller.api.CarrosController;
import com.victation.AppLocacao.model.domain.Carro;
import com.victation.AppLocacao.model.domain.Usuario;
import com.victation.AppLocacao.model.repository.CarroRepository;
import com.victation.AppLocacao.model.test.AppImpressao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.Collection;

@Service
public class CarroService {

    private static Logger logger = LoggerFactory.getLogger(CarroService.class);

    @Autowired
    private CarroRepository carroRepository;

    public Collection<Carro> obterLista(){
        logger.info("Buscando  lista de carros no banco");
        return (Collection<Carro>) carroRepository.findAll();
    }

    public Collection<Carro> obterLista(Usuario user){
        return (Collection<Carro>) carroRepository.findAll(user.getId());
    }
    public  void excluir(Integer id){
        carroRepository.deleteById(id);
    }

    public void incluir(Carro carro, @SessionAttribute("user") Usuario user){
        carro.setUsuario(user);
        carroRepository.save(carro);
 }

}
