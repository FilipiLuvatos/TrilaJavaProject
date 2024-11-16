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
    private Integer fkAdPessoa;
    private Integer  fkNumConta;
    private TypeTransacao tipo;
    private double saladoMovimenta;
    private Date dtTransacao;
    private double valorMoeda;
    private String moeda;
    private double total;
}
