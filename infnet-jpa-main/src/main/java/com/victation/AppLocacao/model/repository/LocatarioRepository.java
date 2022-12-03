package com.victation.AppLocacao.model.repository;

import com.victation.AppLocacao.model.domain.Locatario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public interface LocatarioRepository extends CrudRepository <Locatario, Integer> {

    @Query("from Locatario l where l.usuario.id = :usuarioid")
    Collection<Locatario> obterLista(Integer usuarioid) ;
}
