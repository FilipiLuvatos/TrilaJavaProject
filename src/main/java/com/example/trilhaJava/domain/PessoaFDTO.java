package com.example.trilhaJava.domain;

import com.example.trilhaJava.enumeration.TipoPessoa;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;



@Data
public class PessoaFDTO {

    @NotBlank
    private String nome;
    @NotBlank
    private String sobreNome;
    @NotBlank
    private int doc;
    @NotBlank
    private Date dNascimento;
    @NotBlank
    private Date cliDesde;
    @NotBlank
    private TipoPessoa pessoa;
    private EnderecoDTO endereco;
    @NotBlank
    private int nConta;
    //private UserDTO usuario;
}
