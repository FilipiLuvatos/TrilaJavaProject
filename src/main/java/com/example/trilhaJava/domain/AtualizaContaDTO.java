package com.example.trilhaJava.domain;

import com.example.trilhaJava.enumeration.StatusConta;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AtualizaContaDTO {

    private Long id;

    private int numConta;
    private float saldo;

    private StatusConta status;

}
