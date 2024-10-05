package com.example.trilhaJava.domain;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class UserDTO {

    private int user;
    private String email;
    private String pass;
}
