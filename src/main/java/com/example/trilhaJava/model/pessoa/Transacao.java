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
    @Column(name = "fk_ad_pessoa")
    private  Integer fkAdPessoa;
    @Column(name = "fk_num_Conta")
    private Integer  fkNumConta;
    @Enumerated(EnumType.STRING)
    private TypeTransacao tipo;
    @Column(name = "saladoMovimenta")
    private double saladoMovimenta;
    @Column(name = "dt_Transacao")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:mm")
    private Date dtTransacao;
    @Column(name = "valorMoeda")
    private double valorMoeda;
    private String moeda;
    @Column(name = "total")
    private double total;


    public Transacao(TransacaoDTO transacao) {
        this.id = transacao.getId();
        this.fkAdPessoa = transacao.getFkAdPessoa();
        this.saladoMovimenta = transacao.getSaladoMovimenta();
        this.dtTransacao = transacao.getDtTransacao();
        this.fkNumConta = transacao.getFkNumConta();
        this.tipo = transacao.getTipo();
        this.valorMoeda = transacao.getValorMoeda();
        this.total = transacao.getTotal();
        this.moeda = transacao.getMoeda();
    }

    public void AtualizaDados(AtualizaTransacaoDTO dadoTransacao){
        this.saladoMovimenta = dadoTransacao.getSaladoMovimenta();
        this.fkNumConta = dadoTransacao.getFkNumConta();
    }
}
