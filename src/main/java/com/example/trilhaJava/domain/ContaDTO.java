package com.example.trilhaJava.domain;

import com.example.trilhaJava.enumeration.StatusConta;
import com.example.trilhaJava.enumeration.TipoPessoa;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;
@Getter
@Data
public class ContaDTO {

    private long id;

    @NotBlank
    private int numConta;
    private float saldo;
    @NotBlank
    private StatusConta status;
}
