package com.example.trilhaJava.pessoa;

import com.example.trilhaJava.domain.EnderecoDTO;
import com.example.trilhaJava.enumeration.TipoPessoa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "Pessoa_Fisica")
@Entity(name = "pessoa")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PessoaF {

    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
