package com.example.trilhaJava.repository;

import com.example.trilhaJava.model.pessoa.Conta;
import com.example.trilhaJava.model.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContaRepository extends JpaRepository <Conta, Long> {
    @Query(value = """
        select * from conta 
        where fk_num_Conta = :numConta
        """, nativeQuery = true)
    List<Conta> getConsultaConta(Long numConta);
}
