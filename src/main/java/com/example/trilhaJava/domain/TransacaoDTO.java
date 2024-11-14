package com.example.trilhaJava.domain;

import com.example.trilhaJava.enumeration.TypeTransacao;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Data
public class TransacaoDTO {

    private Long id;
    private Integer  numConta;
    private TypeTransacao tipo;
    private double saladoMovimenta;
    private Date tempo;
    private double valorMoeda;
    private String moeda;
    private double total;
}
