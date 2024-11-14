package com.example.trilhaJava.service;

import com.example.trilhaJava.domain.AtualizaContaDTO;
import com.example.trilhaJava.domain.ContaDTO;
import com.example.trilhaJava.enumeration.StatusConta;
import com.example.trilhaJava.enumeration.TypeTransacao;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ValidaContaService {

    public void validaConta(ContaDTO conta){

        if (conta.getNumConta() == null || conta.getNumConta() < 0) {
            throw new IllegalArgumentException("[Número da conta incorreto]");
        }
        if (conta.getStatus() == null) {
            throw new IllegalArgumentException("[O tipo de status não pode ser nulo.]");
        }

        boolean statusValido = Arrays.stream(StatusConta.values())  // Usa StatusConta em vez de TypeTransacao
                .anyMatch(status -> status == conta.getStatus());

        if (!statusValido) {
            throw new IllegalArgumentException("Status da conta inválido. Tipos válidos são: " + Arrays.toString(StatusConta.values()));
        }


    }

    public void validaAtualizaConta(AtualizaContaDTO atualiza){
        if (atualiza.getNumConta() == null || atualiza.getNumConta() < 0) {
            throw new IllegalArgumentException("[Número da conta incorreto]");
        }
        if (atualiza.getStatus() == null) {
            throw new IllegalArgumentException("[O tipo de status não pode ser nulo.]");
        }

        boolean statusValido = Arrays.stream(StatusConta.values())  // Usa StatusConta em vez de TypeTransacao
                .anyMatch(status -> status == atualiza.getStatus());

        if (!statusValido) {
            throw new IllegalArgumentException("Status da conta inválido. Tipos válidos são: " + Arrays.toString(StatusConta.values()));
        }

    }

}
