package com.example.trilhaJava.domain;

import com.example.trilhaJava.enumeration.StatusConta;
import com.example.trilhaJava.enumeration.TipoPessoa;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ContaDTO {

    private int numConta;
    private float saldo;
    private StatusConta status;
}
