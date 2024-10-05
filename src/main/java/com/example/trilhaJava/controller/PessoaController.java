package com.example.trilhaJava.controller;

import com.example.trilhaJava.domain.DadosListaOnePessoaDTO;
import com.example.trilhaJava.domain.PessoaFDTO;
import com.example.trilhaJava.pessoa.PessoaF;
import com.example.trilhaJava.repository.PessoaFRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    private PessoaFRepository pessoaRepository;

    @PostMapping
    @Transactional
    public void cadastrarPessoa(@RequestBody PessoaFDTO pessoaF) {
        pessoaRepository.save(new PessoaF(pessoaF));

        System.out.println("TestePessoa:" + pessoaF);
    }

    @GetMapping("/all")
    public List<PessoaF>listaPessoaAll(){
        return pessoaRepository.findAll();
    }


    @GetMapping("/one")
    public List<DadosListaOnePessoaDTO>listaPessoaOne(){
        return pessoaRepository.findAll().stream().map(DadosListaOnePessoaDTO:: new).toList();
    }
}
