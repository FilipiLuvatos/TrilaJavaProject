package com.example.trilhaJava.pessoa;

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

@Table(name = "PessoaFisica")
@Entity(name = "pessoa")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PessoaF {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String sobreNome;
    private int doc;
    private LocalDate dNascimento;
    private LocalDate cliDesde;
    @Enumerated(EnumType.STRING)
    private TipoPessoa pessoa;
    @Embedded
    private EnderecoDTO endereco;
    private int nConta;


    public PessoaF(PessoaFDTO pessoaF) {


        this.nome = pessoaF.getNome();
        this.sobreNome = pessoaF.getSobreNome();
        this.doc = pessoaF.getDoc();
        this.dNascimento = pessoaF.getDNascimento();
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

}
