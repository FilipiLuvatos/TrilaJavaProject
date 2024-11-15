package com.example.trilhaJava.model.pessoa;

import com.example.trilhaJava.domain.AtualizaPessoaDTO;
import com.example.trilhaJava.domain.EnderecoDTO;
import com.example.trilhaJava.domain.PessoaDTO;
import com.example.trilhaJava.enumeration.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "Pessoa")
@Entity(name = "Pessoa")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "adPessoa")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // Ignora propriedades de proxy do Hibernate
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ad_pessoa")
    private Long adPessoa;  // Usando Long para suportar o AUTO_INCREMENT da tabela

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "sobre_Nome", nullable = false)
    private String sobreNome;

    @Column(name = "doc", nullable = false)
    private Long doc;  // Utilizando Long para suportar números maiores


    @Column(name = "dt_Nascimento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dtNascimento;

    @Column(name = "cli_Desde", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date cliDesde;

    @Column(name = "pessoa", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoPessoa pessoa;

    @Column(name = "num_Conta", nullable = false)
    private int numConta;

    @Embedded
    private EnderecoDTO endereco;

    public Pessoa(PessoaDTO pessoa){
        this.adPessoa = pessoa.getAdPessoa();
        this.doc = pessoa.getDoc();
        this.nome = pessoa.getNome();
        this.sobreNome = pessoa.getSobreNome();;
        this.cliDesde = pessoa.getCliDesde();
        this.dtNascimento = pessoa.getDtNascimento();
        this.numConta = pessoa.getNumConta();

        String tipoPessoa = String.valueOf(pessoa.getPessoa());
        this.pessoa = TipoPessoa.valueOf(tipoPessoa.toUpperCase());


        EnderecoDTO enderecoDTO = pessoa.getEndereco();
        if (enderecoDTO != null) {
            this.endereco = enderecoDTO;
        } else {
            this.endereco = new EnderecoDTO();
        }
    }

    public void atualizarInfos(AtualizaPessoaDTO dadosAtua) {
        this.doc = dadosAtua.getDoc();
        this.nome = dadosAtua.getNome();
    }
}
