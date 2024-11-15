package com.example.trilhaJava.domain;

import com.example.trilhaJava.enumeration.TipoPessoa;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class AtualizaPessoaDTO {

    private Long id;

    private Long ad_pessoa;

    
    private String nome;

    
    private String sobreNome;


    private long doc;

    
    private Date dNascimento;

    
    private Date cliDesde;

    
    private TipoPessoa pessoa;
    private EnderecoDTO endereco;

    
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

    public void setDoc(int doc) {
        this.doc = doc;
    }

    public void setPessoa(TipoPessoa pessoa) {
        this.pessoa = pessoa;
    }
}
