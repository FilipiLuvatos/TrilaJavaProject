package com.example.trilhaJava.service;

import com.example.trilhaJava.domain.MoneyDTO;
import com.example.trilhaJava.domain.TransacaoDTO;
import com.example.trilhaJava.model.pessoa.Transacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class MoneyApiConverService {

    @Value("${api.key}")
    public String apiKey;

    public TransacaoDTO converteTransacao(TransacaoDTO transacao){

        if (!transacao.getMoeda().equals("BRL")) {
            //String apiKey = "de4c804a426ed1b27bc4237ed614c0a5";

            System.out.println("TESTE");
            String url = "https://api.exchangeratesapi.io/v1/latest?access_key=" + apiKey;
            RestTemplate restTemplate = new RestTemplate();
            MoneyDTO response = restTemplate.getForObject(url, MoneyDTO.class);

            double valueMoney = response.getRates().get(transacao.getMoeda());//DOLAR
            double valueMoneyEuro = response.getRates().get("BRL");
            double valorConvertido = converteMoeda(valueMoney, valueMoneyEuro, transacao.getSaladoMovimenta());
            transacao.setValorMoeda(valueMoney);
            transacao.setTotal(valorConvertido);
            return transacao;
        }
        transacao.setValorMoeda(1.0);
        transacao.setTotal(transacao.getSaladoMovimenta());
        return transacao;

    }

    public static double converteMoeda(double moeda, double real, double vlFornecido){
        double va1, va2, va3, res1, resTotal;

        res1 = (vlFornecido/moeda);

        resTotal = res1 * real;

        return resTotal;
    }

}
