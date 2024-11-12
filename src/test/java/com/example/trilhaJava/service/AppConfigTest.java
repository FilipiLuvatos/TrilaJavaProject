package com.example.trilhaJava.service;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class AppConfigTest {

    @Test
    void restTemplate() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Obtém o bean do tipo RestTemplate
        RestTemplate restTemplate = context.getBean(RestTemplate.class);

        // Verifica se o bean RestTemplate foi criado com sucesso
        assertNotNull(restTemplate, "O bean RestTemplate deve estar configurado e não deve ser nulo.");

        // Fecha o contexto para liberar recursos
        context.close();
    }
}