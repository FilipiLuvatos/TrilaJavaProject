package com.example.trilhaJava.service;


import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class CriptoService {

    public static String hashPassword(String plainPassword) {//Criptografa
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    public static boolean checkPassword(String plainPassword, String hashedPassword) { //Verifica se o hash bate
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
