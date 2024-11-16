package com.example.trilhaJava.repository;

import com.example.trilhaJava.enumeration.TypeTransacao;
import com.example.trilhaJava.model.pessoa.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    @Query(value = """
        select * from transaction_Value ts
        where ts.fk_num_conta = :num_conta
        """, nativeQuery = true)
    List<Transacao> getTransacaoConta(Integer num_conta);


    @Query(value = """
            SELECT *
            FROM transaction_Value
            WHERE fk_num_conta = :num_conta
            AND dt_Transacao >= :dt_ini
            AND tipo = :tipotipo     
            """, nativeQuery = true)
    List<Transacao>getTransacao(Long num_conta, LocalDate dt_ini, TypeTransacao tipotipo);
}
