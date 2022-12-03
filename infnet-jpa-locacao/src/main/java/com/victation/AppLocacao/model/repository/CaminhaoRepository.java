package com.victation.AppLocacao.model.repository;

import com.victation.AppLocacao.model.domain.Caminhao;
import com.victation.AppLocacao.model.domain.Locatario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CaminhaoRepository extends CrudRepository <Caminhao, Integer> {

    @Query("from Caminhao c where c.usuario.id = :idUsuario")
    Collection<Caminhao> findAll(Integer idUsuario);
}
