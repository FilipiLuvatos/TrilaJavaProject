package com.example.trilhaJava.repository;

import com.example.trilhaJava.model.pessoa.Pessoa;
import com.example.trilhaJava.model.pessoa.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {
    UserDetails findByLogin(String login);

    @Query(value = """
        select * from usuario p
        where p.ad_pessoa = :ad_pessoa
        """, nativeQuery = true)
    List<Usuario> getConsultaUsuario(Long ad_pessoa);
}
