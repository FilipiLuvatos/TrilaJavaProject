package com.example.trilhaJava.service;

import com.example.trilhaJava.domain.MoneyDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class MoneyApiControService {

    @Value("${api.key}")
    public String apiKey;
    public MoneyDTO consultaMoneyApi(){
        String url = "https://api.exchangeratesapi.io/v1/latest?access_key=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();
        MoneyDTO response = restTemplate.getForObject(url, MoneyDTO.class);
        return  response;
    }


}
