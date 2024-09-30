package com.example.trilhaJava.domain;

import com.example.trilhaJava.enumeration.TipoPessoa;
import lombok.Data;

import java.time.LocalDate;


// Avaliando a possibilidade de usar
@Data
public class PessoaFDTO {

    private String nome;
    private String sobreNome;
    private int doc;
    private LocalDate dNascimento;
    private LocalDate cliDesde;
    private TipoPessoa pessoa;
    private EnderecoDTO endereco;
    private int nConta;
}
