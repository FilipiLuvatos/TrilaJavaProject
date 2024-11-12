package com.example.trilhaJava.service;

import com.example.trilhaJava.domain.MoneyDTO;
import com.example.trilhaJava.domain.TransacaoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class MoneyApiConverServiceTest {


    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private MoneyApiConverService moneyApiConverService;

    @Value("${api.key}")
    private String apiKey;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void converteTransacao() {
        // Configura o objeto TransacaoDTO
        TransacaoDTO transacao = new TransacaoDTO();
        transacao.setMoeda("USD");
        transacao.setSaladoMovimenta(100.0);

        // Configura o objeto MoneyDTO de resposta
        MoneyDTO mockResponse = new MoneyDTO();
        Map<String, Double> rates = new HashMap<>();
        rates.put("USD", 1.2); // Taxa de câmbio fictícia para USD
        rates.put("BRL", 5.5); // Taxa de câmbio fictícia para BRL
        mockResponse.setRates(rates);

        // Configura o comportamento do RestTemplate mock
        String url = "https://api.exchangeratesapi.io/v1/latest?access_key=" + apiKey;
        when(restTemplate.getForObject(url, MoneyDTO.class)).thenReturn(mockResponse);

        // Executa o método a ser testado
        TransacaoDTO resultado = moneyApiConverService.converteTransacao(transacao);

        // Verifica o resultado da conversão
        assertEquals(1.2, resultado.getValorMoeda());
        assertEquals(458.33, resultado.getTotal(), 0.01); // Total esperado arredondado para duas casas
    }

    @Test
    void converteMoeda() {

        // Teste simples de conversão de moeda
        double moeda = 1.2; // Exemplo: USD para BRL
        double real = 5.5;  // Exemplo: BRL para a moeda de destino
        double vlFornecido = 100.0; // Valor a ser convertido

        // Chamando a função de conversão
        double resultado = MoneyApiConverService.converteMoeda(moeda, real, vlFornecido);

        // Verificando o resultado esperado
        double resultadoEsperado = (vlFornecido / moeda) * real;
        assertEquals(resultadoEsperado, resultado, 0.01);  // Verifica se o valor calculado é igual ao esperado com precisão de 2 casas decimais
    }
}