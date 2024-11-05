package com.example.trilhaJava.domain;

import com.example.trilhaJava.enumeration.TypeTransacao;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Getter
@Data
public class TransacaoDTO {

    private Long id;
    private int numConta;
    private TypeTransacao tipo;
    private double saladoMovimenta;
    private Date tempo;
    private double valorMoeda;
    private String moeda;
    private double total;
}
