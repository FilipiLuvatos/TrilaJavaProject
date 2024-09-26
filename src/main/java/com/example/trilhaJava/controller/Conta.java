package com.example.trilhaJava.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta")
public class Conta {


    @PostMapping("/cadastrar/{n_conta}")
    public void cadastrarConta(@PathVariable ("n_conta") int N_Conta) {

        System.out.println("Teste_Conta:" + N_Conta);
    }

}
