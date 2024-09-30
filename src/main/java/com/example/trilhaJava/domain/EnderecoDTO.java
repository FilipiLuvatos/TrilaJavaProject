package com.example.trilhaJava.domain;

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
    private String end;
    private int num;
    private int cep;

}
