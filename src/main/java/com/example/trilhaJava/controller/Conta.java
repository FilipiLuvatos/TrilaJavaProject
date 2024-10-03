package com.example.trilhaJava.controller;

import com.example.trilhaJava.domain.ContaDTO;
import com.example.trilhaJava.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta")
public class Conta {


    @Autowired
    private ContaRepository repositoryConta;
    @PostMapping
    public void cadastrarConta(@RequestBody ContaDTO N_Conta) {
        repositoryConta.save(new com.example.trilhaJava.pessoa.Conta(N_Conta));

        System.out.println("Teste_Conta:" + N_Conta);
    }

}
