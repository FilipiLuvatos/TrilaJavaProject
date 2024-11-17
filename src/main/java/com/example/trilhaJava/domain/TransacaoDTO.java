package com.example.trilhaJava.domain;

import com.example.trilhaJava.enumeration.TypeTransacao;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Data
public class TransacaoDTO {

    @NotNull(message = "ID não pode ser nulo.")
    private Long id;

    @NotNull(message = "Pessoa associada (fkAdPessoa) não pode ser nula.")
    private Integer fkAdPessoa;

    @NotNull(message = "Número da conta (fkNumConta) não pode ser nulo.")
    private Integer fkNumConta;

    @NotNull(message = "Tipo de transação não pode ser nulo.")
    private TypeTransacao tipo;  // Supondo que seja uma enumeração

    @NotNull(message = "Saldo da movimentação não pode ser nulo.")
    private double saladoMovimenta;

    @NotNull(message = "Data da transação não pode ser nula.")
    private Date dtTransacao;

    @NotNull(message = "Valor da moeda não pode ser nulo.")
    private double valorMoeda;

    @NotNull(message = "Moeda não pode ser nula.")
    private String moeda;

    @NotNull(message = "Total da transação não pode ser nulo.")
    private double total;
}
