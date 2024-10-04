package com.example.trilhaJava.domain;

import com.example.trilhaJava.enumeration.StatusConta;
import com.example.trilhaJava.enumeration.TipoPessoa;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ContaDTO {

    @NotBlank
    private int numConta;
    private float saldo;
    @NotBlank
    private StatusConta status;
}
