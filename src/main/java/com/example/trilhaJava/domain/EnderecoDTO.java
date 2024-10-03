package com.example.trilhaJava.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Data
@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {

    private String uf;
    private String pais;
    private String cidade;
    private String endereco;
    private String bairro;
    private int numero;
    @Column(name = "cep")
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


