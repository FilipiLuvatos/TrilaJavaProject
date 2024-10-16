package com.example.trilhaJava.domain;

import com.example.trilhaJava.enumeration.TipoPessoa;
import com.example.trilhaJava.model.pessoa.PessoaF;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class DadosListaOnePessoaDTO {

    private Long id;
    @NotBlank
    private String nome;

    @NotBlank
    private String sobreNome;

    @NotBlank
    private TipoPessoa pessoa;

    @NotBlank
    private int nConta;

    public DadosListaOnePessoaDTO(PessoaF dadosListaOnePessoaDTO) {
        this.id = dadosListaOnePessoaDTO.getId();
        this.nome = dadosListaOnePessoaDTO.getNome();
        this.sobreNome = dadosListaOnePessoaDTO.getSobreNome();
        this.pessoa = dadosListaOnePessoaDTO.getPessoa();
        this.nConta = dadosListaOnePessoaDTO.getNConta();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public void setPessoa(TipoPessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void setnConta(int nConta) {
        this.nConta = nConta;
    }

    public void setId(long id) {
        this.id = id;
    }
}
