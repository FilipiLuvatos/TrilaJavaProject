package com.example.trilhaJava.model.pessoa;

import com.example.trilhaJava.domain.AtualizaContaDTO;
import com.example.trilhaJava.domain.ContaDTO;
import com.example.trilhaJava.enumeration.StatusConta;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "Conta")
@Entity(name = "conta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "num_Conta")
    private int numConta;
    private float saldo;
    @Enumerated(EnumType.STRING)
    private StatusConta status;

    public Conta(ContaDTO dados) {

        this.numConta = dados.getNumConta();
        this.saldo = dados.getSaldo();

        // Verifique se o status não é nulo antes de chamar toUpperCase()
        String statusString = String.valueOf(dados.getStatus());
        if (statusString != null) {
            try {
                this.status = StatusConta.valueOf(statusString.toUpperCase());
            } catch (IllegalArgumentException e) {
                // Lidar com status inválido
                System.err.println("Status inválido: " + statusString);

            }
        } else {
            // Tratar o caso em que o status é null
            System.err.println("Status é null.");

        }


    }
    public void atualizarInfosConta(AtualizaContaDTO dadosContaAtua) {
        this.saldo = dadosContaAtua.getSaldo();

        this.status = dadosContaAtua.getStatus();
    }
}
