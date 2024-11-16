package com.example.trilhaJava.domain;

import com.example.trilhaJava.enumeration.StatusConta;
import com.example.trilhaJava.enumeration.TipoPessoa;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Data
@Setter
public class ContaDTO {

    private long id;
    private Integer fkAdPessoa;
    private Integer fkNumConta;
    private float saldo;
    private StatusConta status;
}
