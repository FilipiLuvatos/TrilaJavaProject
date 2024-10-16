package com.example.trilhaJava.domain;

import com.example.trilhaJava.enumeration.TipoPessoa;
import com.example.trilhaJava.pessoa.PessoaF;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;

import java.util.Date;


@Getter
@Data
public class PessoaFDTO {

    private Long id;
  
    @NotBlank
    private String nome;
  
    @NotBlank
    private String sobreNome;
  

    private Long doc;
  
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


    public void setdNascimento(Date dNascimento) {
        this.dNascimento = dNascimento;
    }

    public void setCliDesde(Date cliDesde) {
        this.cliDesde = cliDesde;
    }

    public void setnConta(int nConta) {
        this.nConta = nConta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public void setDoc(Long doc) {
        this.doc = doc;
    }

    public void setPessoa(TipoPessoa pessoa) {
        this.pessoa = pessoa;
    }
}
