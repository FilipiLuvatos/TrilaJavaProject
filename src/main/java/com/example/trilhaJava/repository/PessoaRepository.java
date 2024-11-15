package com.example.trilhaJava.repository;

import com.example.trilhaJava.model.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    @Query(value = """
        select * from pessoa p
        where p.ad_pessoa = :ad_pessoa
        """, nativeQuery = true)
    List<Pessoa> getConsultaPessoa(Long ad_pessoa);

    @Query(value = """
            delete from pessoa p
            where p.ad_pessoa = :ad_pessoa
            """,nativeQuery = true)
    void deletaPessoa(Long ad_pessoa);
}
