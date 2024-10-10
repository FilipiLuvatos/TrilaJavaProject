package com.example.trilhaJava.domain;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class UserDTO {

    private Long id;
    private String login;
    private String pass;
}
