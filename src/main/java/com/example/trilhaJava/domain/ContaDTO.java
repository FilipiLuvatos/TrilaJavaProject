package com.example.trilhaJava.domain;

import com.example.trilhaJava.enumeration.StatusConta;
import com.example.trilhaJava.enumeration.TipoPessoa;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ContaDTO {

    private int nConta;
    private int docConta;
    private int saldo;
    private StatusConta status;
}
