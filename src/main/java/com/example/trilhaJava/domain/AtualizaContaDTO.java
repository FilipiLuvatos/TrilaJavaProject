package com.example.trilhaJava.domain;

import com.example.trilhaJava.enumeration.StatusConta;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AtualizaContaDTO {

    private Long id;

    @NotNull(message = "Número da conta não pode ser nulo.")
    private Integer numConta;

    @NotNull(message = "Saldo não pode ser nulo.")
    private float saldo;

    @NotNull(message = "Status da conta não pode ser nulo.")
    private StatusConta status;
}