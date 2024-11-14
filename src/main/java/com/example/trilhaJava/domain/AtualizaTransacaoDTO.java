package com.example.trilhaJava.domain;

import com.example.trilhaJava.enumeration.TypeTransacao;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class AtualizaTransacaoDTO {

    private Long id;
    private Integer numConta;
    private TypeTransacao tipo;
    private double saladoMovimenta;
    private Date tempo;
}
