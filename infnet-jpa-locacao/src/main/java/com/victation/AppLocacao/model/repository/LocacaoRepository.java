package com.victation.AppLocacao.model.repository;


import com.victation.AppLocacao.model.domain.Locacao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface LocacaoRepository extends CrudRepository <Locacao, Integer> {

    @Query("from Locacao l where l.usuario.id = :idUsuario")
    Collection<Locacao> findAll(Integer idUsuario);
}
