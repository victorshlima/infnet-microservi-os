package com.victation.AppLocacao.model.repository;


import com.victation.AppLocacao.model.domain.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends CrudRepository <Usuario, Integer> {

    @Query("from Usuario u where u.email = :email")
    Optional<Usuario> findByEmail(String email);
}
