package com.example.trilhaJava.service;

import com.example.trilhaJava.domain.AtualizaTransacaoDTO;
import com.example.trilhaJava.domain.TransacaoDTO;
import com.example.trilhaJava.enumeration.TypeTransacao;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;

@Service
public class ValidaTransacaoService {

    public void validaTransacao(TransacaoDTO transacao) {

        if (transacao.getSaladoMovimenta() < 0.0) {
            throw new IllegalArgumentException("[O valor não pode ser negativo.]");
        }
        else if (transacao.getFkNumConta() == null || transacao.getFkNumConta() < 0) {
            throw new IllegalArgumentException("[O valor da conta não pode ser negativo]");
        }
        else if (transacao.getDtTransacao() == null) {
            throw new IllegalArgumentException("[A data da transação não pode ser nula.]");
        }
        else if (transacao.getDtTransacao().after(new Date())) {
            throw new IllegalArgumentException("[A data da transação não pode ser no futuro.]");
        }
        else if (transacao.getMoeda() == null || transacao.getMoeda().isEmpty()) {
            throw new IllegalArgumentException("[A moeda não pode ser nula ou vazia.]");
        }
        else if (transacao.getTipo() == null) {
            throw new IllegalArgumentException("O tipo de transação não pode ser nulo.");
        }

        boolean tipoValido = Arrays.stream(TypeTransacao.values())
                .anyMatch(tipo -> tipo == transacao.getTipo());

        if (!tipoValido) {
            throw new IllegalArgumentException("Tipo de transação inválido. Tipos válidos são: " + Arrays.toString(TypeTransacao.values()));
        }
    }

    public void validaAtualizaTransacao (AtualizaTransacaoDTO atualiza) {

        if (atualiza.getTipo() == null) {
            throw new IllegalArgumentException("O[[ tipo de transação não pode ser nulo.]]");
        }
        boolean tipoValido = Arrays.stream(TypeTransacao.values())
                .anyMatch(tipo -> tipo == atualiza.getTipo());

        if (!tipoValido) {
            throw new IllegalArgumentException("Tipo de transação inválido. Tipos válidos são: " + Arrays.toString(TypeTransacao.values()));
        } else if (atualiza.getSaladoMovimenta() < 0.0) {
            throw new IllegalArgumentException("[O valor não pode ser negativo.]");
        } else if (atualiza.getTempo() == null) {
            throw new IllegalArgumentException("[A data da transação não pode ser nula.]");
        }
    }


}
