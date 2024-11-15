package com.example.trilhaJava.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Data
@Setter
public class UserDTO {

    private Long id;
    private Long ad_Pessoa;
    private String login;
    private String pass;
}
