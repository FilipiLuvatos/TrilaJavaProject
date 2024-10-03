package com.example.trilhaJava.controller;

import com.example.trilhaJava.domain.ContaDTO;
import com.example.trilhaJava.domain.PessoaFDTO;
import com.example.trilhaJava.pessoa.PessoaF;
import com.example.trilhaJava.repository.PessoaFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")
public class Pessoa {
    @Autowired
    private PessoaFRepository pessoaRepository;

    @PostMapping
    public void cadastrarConta(@RequestBody PessoaFDTO pessoaF) {
        pessoaRepository.save(new PessoaF(pessoaF));

        System.out.println("TestePessoa:" + pessoaF);
    }
}
