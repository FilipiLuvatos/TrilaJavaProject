package com.example.trilhaJava.pessoa;

import com.example.trilhaJava.domain.AtualizaPessoaDTO;
import com.example.trilhaJava.domain.EnderecoDTO;
import com.example.trilhaJava.domain.PessoaFDTO;
import com.example.trilhaJava.enumeration.StatusConta;
import com.example.trilhaJava.enumeration.TipoPessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Table(name = "pessoafisica")
@Entity(name = "pessoaf")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PessoaF {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobre_Nome")
    private String sobreNome;

    @Column(name = "doc")
    private long doc;

    @Column(name = "d_nascimento")
    private Date dNascimento;

    @Column(name = "cli_desde")
    private Date cliDesde;

    @Enumerated(EnumType.STRING)
    private TipoPessoa pessoa;
    @Embedded
    private EnderecoDTO endereco;
    private int nConta;


    public PessoaF(PessoaFDTO pessoaF) {


        this.nome = pessoaF.getNome();
        this.sobreNome = pessoaF.getSobreNome();
        this.doc = pessoaF.getDoc();
        this.dNascimento = pessoaF.getDNascimento();  //
        this.cliDesde = pessoaF.getCliDesde();
        String tipoPessoa = String.valueOf(pessoaF.getPessoa());
        if (tipoPessoa != null) {
            try {
                this.pessoa = TipoPessoa.valueOf(tipoPessoa.toUpperCase());
            } catch (IllegalArgumentException e) {
                // Lidar com status inválido
                System.err.println("Tipo pessoa invalido: " + tipoPessoa);

            }
        }

        EnderecoDTO enderecoDTO = pessoaF.getEndereco();
        if (enderecoDTO != null) {
            this.endereco = enderecoDTO;
        } else {
            this.endereco = new EnderecoDTO();
        }

        this.nConta = pessoaF.getNConta();
    }


    public void atualizarInfos(AtualizaPessoaDTO dadosAtua) {
        this.doc = dadosAtua.getDoc();
    }
}
