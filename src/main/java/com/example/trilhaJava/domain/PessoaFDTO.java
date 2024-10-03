package com.example.trilhaJava.domain;

import com.example.trilhaJava.enumeration.TipoPessoa;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;



@Data
public class PessoaFDTO {

    private String nome;
    private String sobreNome;
    private int doc;
    private Date dNascimento;
    private Date cliDesde;
    private TipoPessoa pessoa;
    private EnderecoDTO endereco;
    private int nConta;
}
