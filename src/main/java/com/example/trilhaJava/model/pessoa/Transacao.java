package com.example.trilhaJava.model.pessoa;

import com.example.trilhaJava.domain.AtualizaTransacaoDTO;
import com.example.trilhaJava.domain.TransacaoDTO;
import com.example.trilhaJava.enumeration.StatusConta;
import com.example.trilhaJava.enumeration.TypeTransacao;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "transactionValue")
@Entity(name = "Transacao")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numConta")
    private int numConta;
    @Enumerated(EnumType.STRING)
    private TypeTransacao tipo;
    @Column(name = "saladoMovimenta")
    private float saladoMovimenta;
    @Column(name = "tempo")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:mm")
    private Date tempo;


    public Transacao(TransacaoDTO transacao) {
        this.saladoMovimenta = transacao.getSaladoMovimenta();
        this.tempo = transacao.getTempo();
        this.numConta = transacao.getNumConta();
        this.tipo = transacao.getTipo();
    }

    public void AtualizaDados(AtualizaTransacaoDTO dadoTransacao){
        this.saladoMovimenta = dadoTransacao.getSaladoMovimenta();
        this.tempo = dadoTransacao.getTempo();
    }
}
