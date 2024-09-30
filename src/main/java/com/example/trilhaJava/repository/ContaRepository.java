package com.example.trilhaJava.repository;

import com.example.trilhaJava.pessoa.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository <Conta, Long> {
}
