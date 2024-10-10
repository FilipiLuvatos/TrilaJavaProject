package com.example.trilhaJava.domain;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class DadosTokenJWTDTO {
    private String token;

    public DadosTokenJWTDTO(String token) {
        this.token = token;
    }

}
