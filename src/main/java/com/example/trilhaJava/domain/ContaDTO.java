package com.example.trilhaJava.domain;

import com.example.trilhaJava.enumeration.StatusConta;
import com.example.trilhaJava.enumeration.TipoPessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Data
@Setter
public class ContaDTO {

    private long id;

    @NotNull(message = "AdPessoa não pode ser nula.")
    private Integer fkAdPessoa;

    @NotNull(message = "Número da conta não pode ser nulo.")
    private Integer fkNumConta;

    @NotNull(message = "O saldo não pode ser nulo.")
    private float saldo;

    @NotNull(message = "O status da conta não pode ser nulo.")
    private StatusConta status;
}
