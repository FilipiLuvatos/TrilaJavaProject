package com.example.trilhaJava.domain;

import com.example.trilhaJava.enumeration.TypeTransacao;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class AtualizaTransacaoDTO {


        private Long id;

        @NotNull(message = "Número da conta não pode ser nulo.")
        private Integer fkNumConta;

        @NotNull(message = "Tipo de transação não pode ser nulo.")
        private TypeTransacao tipo;

        @NotNull(message = "O saldo movimentado não pode ser nulo.")
        private double saladoMovimenta;

        @NotNull(message = "Tempo da movimentação não pode ser nulo.")
        private Date tempo;

}
