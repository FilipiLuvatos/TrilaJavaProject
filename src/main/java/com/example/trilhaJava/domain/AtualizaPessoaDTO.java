package com.example.trilhaJava.domain;

import com.example.trilhaJava.enumeration.TipoPessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class AtualizaPessoaDTO {

    private Long id;

    @NotNull(message = "Pessoa não pode ser nula.")
    private Long ad_pessoa;

    @NotBlank(message = "Nome não pode ser vazio.")
    private String nome;

    @NotBlank(message = "Sobrenome não pode ser vazio.")
    private String sobreNome;

    @NotNull(message = "Documento não pode ser nulo.")
    private long doc;

    @NotNull(message = "Data de nascimento não pode ser nula.")
    private Date dNascimento;

    @NotNull(message = "Data de início do cliente não pode ser nula.")
    private Date cliDesde;

    @NotNull(message = "Tipo de pessoa não pode ser nulo.")
    private TipoPessoa pessoa;

    @NotNull(message = "Endereço não pode ser nulo.")
    private EnderecoDTO endereco;

    private int nConta;

}
