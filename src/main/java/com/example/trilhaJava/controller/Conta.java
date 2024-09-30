package com.example.trilhaJava.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta")
public class Conta {


    @PostMapping
    public void cadastrarConta(@RequestBody String N_Conta) {

        System.out.println("Teste_Conta:" + N_Conta);
    }

}
