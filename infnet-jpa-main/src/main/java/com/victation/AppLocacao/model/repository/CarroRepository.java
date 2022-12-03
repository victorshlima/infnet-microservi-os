package com.victation.AppLocacao.model.repository;

import com.victation.AppLocacao.model.domain.Caminhao;
import com.victation.AppLocacao.model.domain.Carro;
import com.victation.AppLocacao.model.domain.Locatario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CarroRepository extends CrudRepository <Carro, Integer> {

    @Query("from Carro c where c.usuario.id = :idUsuario")
    Collection<Carro> findAll(Integer idUsuario);

}
