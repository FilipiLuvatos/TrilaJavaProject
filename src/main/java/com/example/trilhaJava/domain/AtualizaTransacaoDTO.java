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
    private int numConta;
    private TypeTransacao tipo;
    private float saladoMovimenta;
    private Date tempo;
}
