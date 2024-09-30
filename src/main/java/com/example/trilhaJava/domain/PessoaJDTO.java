package com.example.trilhaJava.domain;

import com.example.trilhaJava.enumeration.TipoPessoa;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PessoaJDTO {

    private String nomeResponsavel;
    private int docResponsavel;
    private LocalDate dFundacao;
    private LocalDate cliDesde;
    private TipoPessoa Pessoa;
    private EnderecoDTO endereco;
    private int nConta;
}
