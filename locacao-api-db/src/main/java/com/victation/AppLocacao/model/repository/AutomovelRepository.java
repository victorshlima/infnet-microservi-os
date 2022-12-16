package com.victation.AppLocacao.model.repository;

import com.victation.AppLocacao.model.domain.Automovel;
import com.victation.AppLocacao.model.domain.Caminhao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AutomovelRepository extends CrudRepository <Automovel, Integer> {

    @Query("from Automovel a where a.usuario.id = :idUsuario")
    Collection<Automovel> findAll(Integer idUsuario);
}
