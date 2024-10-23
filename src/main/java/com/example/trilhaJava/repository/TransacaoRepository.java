package com.example.trilhaJava.repository;

import com.example.trilhaJava.model.pessoa.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
