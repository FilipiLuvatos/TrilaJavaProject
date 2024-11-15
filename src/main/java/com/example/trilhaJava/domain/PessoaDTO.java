package com.example.trilhaJava.domain;

import com.example.trilhaJava.enumeration.TipoPessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Data
public class PessoaDTO {

    private Long adPessoa;

    @NotBlank(message = "O nome é obrigatório")  // Valida que o campo nome não é vazio
    private String nome;

    @NotBlank(message = "O sobrenome é obrigatório")  // Valida que o campo sobrenome não é vazio
    private String sobreNome;

    @NotNull(message = "O documento é obrigatório")  // Valida que o campo documento não é nulo
    @Positive(message = "O documento deve ser um número positivo")  // Valida que o documento seja positivo
    private Long doc;

    @NotNull(message = "A data de nascimento é obrigatória")  // Valida que a data de nascimento não é nula
    private Date dtNascimento;

    @NotNull(message = "A data de cadastro é obrigatória")  // Valida que a data de cadastro não é nula
    private Date cliDesde;

    @NotNull(message = "O tipo de pessoa é obrigatório")  // Valida que o tipo de pessoa (FISICA ou JURIDICA) não é nulo
    private TipoPessoa pessoa;

    @NotNull(message = "O número da conta é obrigatório")  // Valida que o número da conta não é nulo
    @Positive(message = "O número da conta deve ser positivo")
    private Integer numConta;

    private EnderecoDTO endereco;
}
