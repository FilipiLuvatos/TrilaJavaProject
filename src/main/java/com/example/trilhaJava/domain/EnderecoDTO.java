package com.example.trilhaJava.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {

    @NotNull(message = "UF não pode ser nulo.")
    private String uf;

    @NotEmpty(message = "País não pode ser vazio.")
    private String pais;

    @NotEmpty(message = "Cidade não pode ser vazia.")
    private String cidade;

    @NotEmpty(message = "Endereço não pode ser vazio.")
    private String endereco;

    @NotEmpty(message = "Bairro não pode ser vazio.")
    private String bairro;

    private int numero;

    @NotNull(message = "CEP não pode ser nulo.")
    private int cep;

    public EnderecoDTO(EnderecoDTO enderecoDTO) {
        if (enderecoDTO != null) {
            this.uf = enderecoDTO.getUf();
            this.pais = enderecoDTO.getPais();
            this.cidade = enderecoDTO.getCidade();
            this.endereco = enderecoDTO.getEndereco();
            this.bairro = enderecoDTO.getBairro();
            this.numero = enderecoDTO.getNumero();
            this.cep = enderecoDTO.getCep();
        }
    }

}


