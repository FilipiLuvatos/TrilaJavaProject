package com.example.trilhaJava.controller;

import com.example.trilhaJava.domain.MoneyDTO;
import lombok.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


@RestController
@RequestMapping("/money")
public class MoneyApiController {

    @org.springframework.beans.factory.annotation.Value("${api.key}")
    private String apiKey;

    @GetMapping("/exchange-rates")
    public MoneyDTO getExchangeRates() {
        String url = "https://api.exchangeratesapi.io/v1/latest?access_key=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();
        MoneyDTO response = restTemplate.getForObject(url, MoneyDTO.class);
        System.out.println(response.getRates().get("USD"));
        return response;
    }
}
