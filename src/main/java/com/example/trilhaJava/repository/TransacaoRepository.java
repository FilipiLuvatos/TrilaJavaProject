package com.example.trilhaJava.repository;

import com.example.trilhaJava.model.pessoa.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    @Query(value = """
        select * from transaction_Value ts
        where ts.num_conta = :num_conta
        """, nativeQuery = true)
    List<Transacao> getTransacaoConta(Integer num_conta);
}
