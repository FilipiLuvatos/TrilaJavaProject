package com.example.trilhaJava.controller;

import com.example.trilhaJava.domain.MoneyDTO;
import com.example.trilhaJava.service.MoneyApiControService;
import com.example.trilhaJava.service.MoneyApiService;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


@RestController
@RequestMapping("/money")
public class MoneyApiController {

    @Autowired
    private MoneyApiControService moneyApiControService;
    @GetMapping("/exchange-rates")
    public MoneyDTO getExchangeRates() {
        return moneyApiControService.consultaMoneyApi();
    }
}
