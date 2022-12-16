package com.victation.AppLocacao.model.repository;

import com.victation.AppLocacao.model.domain.Carro;
import com.victation.AppLocacao.model.domain.Locatario;
import com.victation.AppLocacao.model.domain.Moto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface MotoRepository extends CrudRepository <Moto, Integer> {

    @Query("from Moto m where m.usuario.id = :idUsuario")
    Collection<Moto> findAll(Integer idUsuario);
}
