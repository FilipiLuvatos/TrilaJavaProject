package com.example.trilhaJava.domain;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class DadosAutenticaDTO {

    public String login;
    public String pass;

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
