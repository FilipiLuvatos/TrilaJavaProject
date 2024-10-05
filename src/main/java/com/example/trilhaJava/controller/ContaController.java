package com.example.trilhaJava.controller;

import com.example.trilhaJava.domain.ContaDTO;
import com.example.trilhaJava.pessoa.Conta;
import com.example.trilhaJava.pessoa.PessoaF;
import com.example.trilhaJava.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {


    @Autowired
    private ContaRepository repositoryConta;
    @PostMapping
    @Transactional
    public void cadastrarConta(@RequestBody ContaDTO N_Conta) {
        repositoryConta.save(new com.example.trilhaJava.pessoa.Conta(N_Conta));

        System.out.println("Teste_Conta:" + N_Conta);
    }

    @GetMapping("/all")
    public List<Conta> listaPessoaAll(){
        return repositoryConta.findAll();
    }

}
