package com.example.trilhaJava.service;

import org.junit.jupiter.api.Test;
import org.mindrot.jbcrypt.BCrypt;

import static org.junit.jupiter.api.Assertions.*;

class CriptoServiceTest {

    @Test
    void hashPassword() {
        String plainPassword = "senhaTeste";
        assertNotNull(CriptoService.hashPassword(plainPassword), "Gera Hash e not null");

        assertNotEquals(CriptoService.hashPassword(plainPassword), "Hash igual a senha string");

        // Verifica se o hash gerado corresponde à senha original
        assertTrue(BCrypt.checkpw(plainPassword, CriptoService.hashPassword(plainPassword)), "O hash deve corresponder " +
                "à senha original");
    }

}