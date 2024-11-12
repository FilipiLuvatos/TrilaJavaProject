package com.example.trilhaJava.service;

import com.example.trilhaJava.model.pessoa.Usuario;
import com.example.trilhaJava.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AutenticaServiceTest {

    @Mock
    private UsuarioRepository repository;

    @InjectMocks
    private AutenticaService autenticaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void loadUserByUsername() {
        String username = "testUser";
        Usuario usuario = new Usuario();
        usuario.setLogin(username);
        usuario.setPass("password");

        when(repository.findByLogin(username)).thenReturn(usuario);

        // Executa o método a ser testado
        UserDetails userDetails = autenticaService.loadUserByUsername(username);

        // Verifica se o usuário retornado não é nulo e tem os dados corretos
        assertNotNull(userDetails);
        assertEquals(username, userDetails.getUsername());
        assertEquals("password", userDetails.getPassword());
    }
}